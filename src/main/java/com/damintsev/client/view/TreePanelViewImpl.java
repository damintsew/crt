package com.damintsev.client.view;

import com.damintsev.common.entity.TreeItem;
import com.damintsev.common.utils.AvalueProvider;
import com.damintsev.common.utils.Dialogs;
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

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
public class TreePanelViewImpl<T extends TreeItem> extends Composite implements TreePanelView<TreeItem> {

    @UiTemplate("TreePanelView.ui.xml")
    interface Binder extends UiBinder<Widget, TreePanelViewImpl> {
    }

    private static Binder uiBinder = GWT.create(Binder.class);
    private Presenter presenter;

    @UiField
    Tree tree;

    @UiConstructor
    public TreePanelViewImpl(final Presenter presenter) {
       initWidget(uiBinder.createAndBindUi(this));
        this.presenter = presenter;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @UiFactory
    public Tree<TreeItem, String> createTree() {
        TreeStore<TreeItem> store = new TreeStore<TreeItem>(new ModelKeyProvider<TreeItem>() {
            @Override
            public String getKey(TreeItem item) {
                return item.getName();
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

    @UiHandler("expandAll")
    public void expandAll(SelectEvent event) {
        Dialogs.alert("FUFUUF");
    }

    @UiHandler("collapseAll")
    public void collapseAll(SelectEvent event) {
        tree.collapseAll();
    }
}
