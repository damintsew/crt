package com.damintsev.client;

import com.damintsev.client.presenter.AnswerFormPresenter;
import com.damintsev.client.presenter.Presenter;
import com.damintsev.client.presenter.TreeAnswerPresenter;
import com.damintsev.client.view.*;
import com.damintsev.common.event.ShowAnswerTreeMenuEvent;
import com.damintsev.common.event.ShowAnswerTreeMenuHandler;
import com.damintsev.common.utils.EventBus;
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

/**
 * Main view. Constructs form with two panels. Left for TreePanel. Right for ContentPanel
 */
public class MainView {

    private static HashMap<String, View> viewMap;
    private static HashMap<String, Presenter> presenterMap;

    private BorderLayoutContainer body;

    public MainView() {
        viewMap = new HashMap<String, View>();
        presenterMap = new HashMap<String, Presenter>();

        Viewport viewport = new Viewport();
        viewport.setStyleName("gwt_main");

        body = new BorderLayoutContainer();
        viewport.add(body);

        FlowLayoutContainer footer = new FlowLayoutContainer();
        footer.setHeight(20);
        footer.setStyleName("footer");
        body.setSouthWidget(footer, new BorderLayoutContainer.BorderLayoutData(20));

        RootPanel.get().add(viewport);

        EventBus.get().addHandler(ShowAnswerTreeMenuEvent.TYPE, new ShowAnswerTreeMenuHandler() {
            @Override
            public void onEvent(ShowAnswerTreeMenuEvent event) {
                TreePanelView.Presenter<TreeItem> presenter = (TreePanelView.Presenter<TreeItem>) presenterMap.get("treeAnswerPresenter");
                if(presenter == null)
                    presenter = initAnswerTreePanel();
                if(body.getWidgetIndex(presenter.asWidget()) == -1)
                    body.setWestWidget(presenter.asWidget(), new BorderLayoutContainer.BorderLayoutData(250));
                if (!presenter.isContentLoaded()) {
                    presenter.loadRootElements();
                }
            }
        });

        EventBus.get().addHandler(ShowAnswerSectionEvent.TYPE, new ShowAnswerSectionHandler() {
            @Override
            public void onShow(ShowAnswerSectionEvent event) {
                AnswerFormView.Presenter presenter = (AnswerFormView.Presenter) presenterMap.get("answerFormPresenter");
                if(presenter == null)
                    presenter = initAnswerForm();
                if(body.getWidgetIndex(presenter.asWidget()) == -1)
                    body.setCenterWidget(presenter.asWidget());
                presenter.loadEntity(event.getAnswerId());
            }
        });
    }

    private AnswerFormView.Presenter initAnswerForm() {
        AnswerFormView answerFormView;
        if ((answerFormView = (AnswerFormView) viewMap.get("answerFormView")) == null) {
            answerFormView = new AnswerFormViewImpl();
            viewMap.put("answerFormView", answerFormView);
        }
        AnswerFormView.Presenter presenter;
        presenter = new AnswerFormPresenter(answerFormView);
        presenterMap.put("answerFormPresenter", presenter);

        return presenter;
    }

    private TreePanelView.Presenter<TreeItem> initAnswerTreePanel() {
        TreePanelView<TreeItem> treePanelView = null;
        if((treePanelView = (TreePanelView<TreeItem>) viewMap.get("answer")) == null) {
            treePanelView = new TreePanelViewImpl<TreeItem>();
            viewMap.put("answer", treePanelView);
        }
        TreeAnswerPresenter presenter = new TreeAnswerPresenter(treePanelView);
            presenterMap.put("treeAnswerPresenter", presenter);

        return presenter;
    }
}
