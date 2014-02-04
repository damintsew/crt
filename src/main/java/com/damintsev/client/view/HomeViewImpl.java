package com.damintsev.client.view;

import com.damintsev.client.presenter.TreePanelPresenter;
import com.damintsev.client.view.testform.TreePanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;

/**
 * @author Damintsev Andrey
 *         04.02.14.
 */
public class HomeViewImpl implements HomeView {

    interface Binder extends UiBinder<Component, HomeViewImpl> {
    }

//    @UiField(provided = true)
//    BorderLayoutContainer.BorderLayoutData westData = new BorderLayoutContainer.BorderLayoutData(200);

    @UiField
    BorderLayoutContainer con;
    @UiField
    TreePanelViewImpl treePanel;

//    @UiField
//    TreePanel treePanel;

    private static Binder uiBinder = GWT.create(Binder.class);

    public HomeViewImpl(Viewport viewport) {
        Widget widget = uiBinder.createAndBindUi(this);
        viewport.add(widget);

    }

    @UiFactory TreePanelViewImpl initTreePanel() {
        return new TreePanelViewImpl(new TreePanelPresenter());
    }
}
