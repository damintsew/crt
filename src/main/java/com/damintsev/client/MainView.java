package com.damintsev.client;

import com.damintsev.client.presenter.AnswerFormPresenter;
import com.damintsev.client.presenter.TreeAnswerPresenter;
import com.damintsev.client.view.*;
import com.damintsev.common.entity.TreeItem;
import com.damintsev.common.event.ShowAnswerSectionEvent;
import com.damintsev.common.event.ShowAnswerSectionHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;

import java.util.HashMap;

/**
 * @author Damintsev Andrey
 *         04.02.14.
 */
public class MainView {

    private HashMap<String, View> viewMap;
    private BorderLayoutContainer body;
    private TreePanelView.Presenter<TreeItem> menuPresenter;
    private AnswerFormView.Presenter centerPresenter;

    public MainView() {
        viewMap = new HashMap<String, View>();

        Viewport viewport = new Viewport();
        viewport.setStyleName("gwt_main");

        body = new BorderLayoutContainer();
        viewport.add(body);


        FlowLayoutContainer footer = new FlowLayoutContainer();
        footer.setHeight(20);
        footer.setStyleName("footer");
        body.setSouthWidget(footer, new BorderLayoutContainer.BorderLayoutData(20));

//        body.setCenterWidget(new ContentPanel());
        RootPanel.get().add(viewport);

        EventBus.get().addHandler(ShowAnswerSectionEvent.TYPE, new ShowAnswerSectionHandler() {
            @Override
            public void onShow(ShowAnswerSectionEvent event) {
                TreePanelView<TreeItem> treePanelView = null;
                if((treePanelView = (TreePanelView<TreeItem>) viewMap.get("answer")) == null) {
                    treePanelView = new TreePanelViewImpl<TreeItem>();
                    viewMap.put("answer", treePanelView);
                }
                if (menuPresenter == null) {
                    menuPresenter = new TreeAnswerPresenter(treePanelView);
                    body.setWestWidget(menuPresenter.asWidget(), new BorderLayoutContainer.BorderLayoutData(250));
                    if (!menuPresenter.isContentLoaded()) {
                        menuPresenter.loadRootElements();
                    }
                }

                AnswerFormView answerFormView;
                if ((answerFormView = (AnswerFormView) viewMap.get("answerFormView")) == null) {
                    answerFormView = new AnswerFormViewImpl();
                    viewMap.put("answerFormView", answerFormView);
                }
                if(centerPresenter == null) {
                    centerPresenter = new AnswerFormPresenter(answerFormView);
                    body.setCenterWidget(centerPresenter.asWidget());
                }
                centerPresenter.loadEntity(event.getAnswerId());


            }
        });
    }
}
