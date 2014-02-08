package com.damintsev.client.view;

import com.damintsev.common.entity.TreeItem;
import com.damintsev.common.entity.TreeNode;
import com.damintsev.common.utils.AvalueProvider;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.*;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.ShowEvent;
import com.sencha.gxt.widget.core.client.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
public class TreePanelViewImpl<T extends TreeItem> implements TreePanelView<T> {

    @UiTemplate("TreePanelView.ui.xml")
    interface Binder extends UiBinder<Widget, TreePanelViewImpl> {
    }

    private static Binder uiBinder = GWT.create(Binder.class);
    private Presenter<T> presenter;

    @UiField
    Tree<T, String> tree;
    @UiField
    TabPanel tabPanel;

    public TreePanelViewImpl() {
       uiBinder.createAndBindUi(this);
    }

    @Override
    public void setRootNodes(List<TreeNode<T>> nodes) {
        tree.getStore().clear();
        for (TreeNode<T> node : nodes) {
            tree.getStore().add(node.getData());
            if (node.haveChildren()) {
                //need to optimize using add(root, List<T>)
                List<T> childs = new ArrayList<T>();
                for (TreeNode<T> child : node.getChildren()) {
                    childs.add(child.getData());
                }
                tree.getStore().add(node.getData(), childs);
            }
        }
    }

    @Override
    public void setPresenter(Presenter<T> presenter) {
        this.presenter = presenter;
    }

    @Override
    public Widget asWidget() {
        return tabPanel;
    }

    @UiFactory
    public Tree<T, String> createTree() {
        TreeStore<T> store = new TreeStore<T>(new ModelKeyProvider<T>() {
            @Override
            public String getKey(T item) {
                return item.getStringId();
            }
        });
        ValueProvider<TreeItem, String> provider = new AvalueProvider<TreeItem, String>("name") {
            @Override
            public String getValue(TreeItem object) {
                return object.getName();
            }
        };
        final Tree<T, String> stringTree = new Tree<T, String>(store, provider);
        stringTree.getSelectionModel().addSelectionHandler(new SelectionHandler<T>() {
            @Override
            public void onSelection(SelectionEvent<T> event) {
                presenter.onEntitySelected(event.getSelectedItem());
            }
        });
        stringTree.addShowHandler(new ShowEvent.ShowHandler() {
            @Override
            public void onShow(ShowEvent event) {
                System.out.println("onShow");
                stringTree.expandAll();
            }
        });

        return stringTree;
    }

    @UiHandler("add")
    public void add(SelectEvent event) {
        presenter.addEntity();
    }

    @UiHandler("remove")
    public void remove(SelectEvent event) {
        T selected = tree.getSelectionModel().getSelectedItem();
        if(selected == null) return;
        presenter.removeEntity(selected);
    }
}
