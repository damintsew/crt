package com.damintsev.client.presenter;

import com.damintsev.client.service.RpcService;
import com.damintsev.client.view.TreePanelView;
import com.damintsev.common.Callback;
import com.damintsev.common.entity.Topic;
import com.damintsev.common.entity.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.TreeStore;

import java.util.Collection;
import java.util.List;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
public class TreeAnswerPresenter implements TreePanelView.Presenter<TreeItem>  {

    private TreePanelView<TreeItem> view;

    public TreeAnswerPresenter(TreePanelView<TreeItem> view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void onEntitySelected(TreeItem selectedEntity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addEntity() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeEntity(TreeItem selected) {

    }

    @Override
    public void loadRootElements() {
        RpcService.instance.loadMenuItems(new Callback<Collection<TreeItem>>() {
            @Override
            protected void onFinish(Collection<TreeItem> result) {
                view.setRootNodes((List<TreeItem>) result);
            }
        });
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }
}
