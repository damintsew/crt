package com.damintsev.client.view.testform;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;

/**
 * @author Damintsev Andrey
 *         04.02.14.
 */
public class HomeView {

    interface Binder extends UiBinder<Component, HomeView> {
    }

//    @UiField(provided = true)
//    BorderLayoutContainer.BorderLayoutData westData = new BorderLayoutContainer.BorderLayoutData(200);

    @UiField
    BorderLayoutContainer con;

    @UiField
    TreePanel treePanel;

    private static Binder uiBinder = GWT.create(Binder.class);

    public HomeView(Viewport viewport) {
        Widget widget = uiBinder.createAndBindUi(this);
        viewport.add(widget);
    }
}
