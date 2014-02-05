package com.damintsev.client.view;

import com.damintsev.common.entity.Entity;
import com.damintsev.common.entity.TreeItem;
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
public class TreePanelViewImpl<T extends TreeItem> extends Composite implements TreePanelView<T> {

    @UiTemplate("TreePanelView.ui.xml")
    interface Binder extends UiBinder<Widget, TreePanelViewImpl> {
    }

    private static Binder uiBinder = GWT.create(Binder.class);
    private Presenter<T> presenter;
    private IntelligentTreeStore<TreeItem> store;

    @UiField
    Tree<T, String> tree;

    @UiConstructor
    public TreePanelViewImpl() {
       initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public  void setRootNodes(List<T> items) {
        tree.getStore().clear();
        tree.getStore().appendAll(items);
    }

    @Override
    public void setPresenter(Presenter<T> presenter) {
        this.presenter = presenter;
    }

    @UiFactory
    public Tree<TreeItem, String> createTree() {
        store = new IntelligentTreeStore<TreeItem>(new ModelKeyProvider<TreeItem>() {
            @Override
            public String getKey(TreeItem item) {
                return item.getName();
            }
        }, new Intell<TreeItem>() {
            @Override
            public TreeItem getParent(TreeItem item) {
                return item.getParent();
            }
        });
        ValueProvider<TreeItem, String> provider = new AvalueProvider<TreeItem, String>("name") {
            @Override
            public String getValue(TreeItem object) {
                return object.getName();
            }
        };
        return new Tree<TreeItem, String>(store, provider);
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

    @UiHandler("tree")
    public void onFocus(FocusEvent event) {

    }

}
