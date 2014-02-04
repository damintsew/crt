package com.damintsev.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.*;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.event.FocusEvent;
import com.sencha.gxt.widget.core.client.tree.Tree;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
public class TreePanelViewImpl extends Composite implements TreePanelView {

    @UiTemplate("TreePanelView.ui.xml")
    interface Binder extends UiBinder<Widget, TreePanelViewImpl> {
    }

    private static Binder uiBinder = GWT.create(Binder.class);
    private Presenter presenter;

    @UiField (provided = true)
    TreeStore store = new TreeStore(new ModelKeyProvider() {
        @Override
        public String getKey(Object item) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }
    });
    @UiField(provided = true)
    ValueProvider valueProvider = new ValueProvider() {
        @Override
        public Object getValue(Object object) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setValue(Object object, Object value) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public String getPath() {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }
    };
    @UiField
    Tree tree;

    @UiConstructor
    public TreePanelViewImpl(final Presenter presenter) {
       initWidget(uiBinder.createAndBindUi(this));
        this.presenter = presenter;
        tree.addFocusHandler(new FocusEvent.FocusHandler() {
            @Override
            public void onFocus(FocusEvent event) {
                presenter.onEntitySelected(event);
            }
        });
    }

//    @UiHandler(value = "focusHandler")
//    public void focusHandler(FocusEvent event) {
//      todo try this
//    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
