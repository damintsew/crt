package com.damintsev.client;

import com.damintsev.client.presenter.TreeAnswerPresenter;
import com.damintsev.client.view.TreePanelView;
import com.damintsev.client.view.TreePanelViewImpl;
import com.damintsev.client.view.View;
import com.damintsev.common.entity.Answer;
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

    public MainView() {
        viewMap = new HashMap<String, View>();

        Viewport viewport = new Viewport();
        viewport.setStyleName("gwt_main");

        body = new BorderLayoutContainer();
        viewport.add(body);

        FlowLayoutContainer header = new FlowLayoutContainer();
        header.setHeight(20);
        body.setNorthWidget(header, new BorderLayoutContainer.BorderLayoutData(20));

        FlowLayoutContainer footer = new FlowLayoutContainer();
        footer.setHeight(20);
        footer.setStyleName("footer");
        body.setSouthWidget(footer, new BorderLayoutContainer.BorderLayoutData(20));

        RootPanel.get().add(viewport);

        EventBus.get().addHandler(ShowAnswerSectionEvent.TYPE, new ShowAnswerSectionHandler() {
            @Override
            public void onShow(ShowAnswerSectionEvent event) {
                TreePanelView<Answer> treePanelView = null;
                if((treePanelView = (TreePanelView<Answer>) viewMap.get("answer")) == null) {
                    treePanelView = new TreePanelViewImpl<Answer>();
                    viewMap.put("answer", treePanelView);
                }
                TreePanelView.Presenter<Answer> presenter = new TreeAnswerPresenter(treePanelView);
                body.setWestWidget(presenter.asWidget());
            }
        });
    }
}
