package com.damintsev.client.presenter;

import com.damintsev.client.service.RpcService;
import com.damintsev.client.view.TreePanelView;
import com.damintsev.common.Callback;
import com.damintsev.common.entity.Answer;
import com.damintsev.common.entity.Entity;
import com.damintsev.common.entity.Topic;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
public class TreeAnswerPresenter implements TreePanelView.Presenter<Topic>  {

    private TreePanelView<Topic> view;

    public TreeAnswerPresenter(TreePanelView<Topic> view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void onEntitySelected(Topic selectedEntity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addEntity() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeEntity(Topic selected) {

    }

    @Override
    public void loadRootElements() {
        RpcService.instance.loadTopics(new Callback<List<Topic>>() {
            @Override
            protected void onFinish(List<Topic> result) {
                view.setRootNodes(result);
            }
        });
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }
}
