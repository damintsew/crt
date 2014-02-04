package com.damintsev.client.presenter;

import com.damintsev.client.view.TreePanelView;
import com.damintsev.common.entity.Answer;
import com.google.gwt.user.client.ui.Widget;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
public class TreeAnswerPresenter implements TreePanelView.Presenter<Answer>  {

    private TreePanelView<Answer> view;

    public TreeAnswerPresenter(TreePanelView<Answer> view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void onEntitySelected(Answer selectedEntity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addEntity() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeEntity(Answer selected) {

    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }

    public void loadInitialData() {
        view.setData(null);
    }
}
