package com.damintsev.client.view;

import com.damintsev.common.entity.Entity;
import com.damintsev.common.entity.TreeItem;
import com.damintsev.common.entity.TreeNode;
import com.damintsev.common.utils.AvalueProvider;
import com.damintsev.common.utils.Dialogs;
import com.damintsev.common.utils.Intell;
import com.damintsev.common.utils.IntelligentTreeStore;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.*;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.event.FocusEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.ShowEvent;
import com.sencha.gxt.widget.core.client.tree.Tree;

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

    @UiConstructor
    public TreePanelViewImpl() {
       uiBinder.createAndBindUi(this);
    }

    @Override
    public  void setRootNodes(List<TreeNode<T>> nodes) {
        tree.getStore().clear();
        for(TreeNode<T> node : nodes) {
            tree.getStore().add(node.getData());
            if(node.haveChildren()) {
                //need to optimize using add(root, List<T>)
                for(TreeNode<T> child : node.getChildren()) {
                    tree.getStore().add(node.getData(), child.getData());
                }
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
                return item.getName();
            }
        });
        ValueProvider<TreeItem, String> provider = new AvalueProvider<TreeItem, String>("name") {
            @Override
            public String getValue(TreeItem object) {
                return object.getName();
            }
        };
        Tree<T, String> stringTree = new Tree<T, String>(store, provider);
        stringTree.addFocusHandler(new FocusEvent.FocusHandler() {
            @Override
            public void onFocus(FocusEvent event) {
                presenter.onEntitySelected(tree.getSelectionModel().getSelectedItem());
            }
        });
        return stringTree;
//        return new Tree<T, String>(store, provider);
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

//    @UiHandler("tree")
//    public void onFocus(FocusEvent event) {
//        presenter.onEntitySelected(tree.getSelectionModel().getSelectedItem());
//    }

}
