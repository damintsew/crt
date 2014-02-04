package com.damintsev.client.view;

import com.damintsev.client.presenter.TreeAnswerPresenter;
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

    @UiField
    BorderLayoutContainer con;
    @UiField
    TreePanelViewImpl treePanel;

    private static Binder uiBinder = GWT.create(Binder.class);

    public HomeViewImpl(Viewport viewport) {
        Widget widget = uiBinder.createAndBindUi(this);
        viewport.add(widget);
    }

    @UiFactory
    TreePanelViewImpl initTreePanel() {
        return new TreePanelViewImpl();
    }
}
