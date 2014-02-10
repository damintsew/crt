package com.damintsev.client.presenter;

import com.damintsev.common.utils.EventBus;
import com.damintsev.client.service.RpcService;
import com.damintsev.client.view.TreePanelView;
import com.damintsev.common.utils.Callback;
import com.damintsev.common.entity.Answer;
import com.damintsev.common.entity.Topic;
import com.damintsev.common.entity.TreeItem;
import com.damintsev.common.utils.TreeNode;
import com.damintsev.common.event.AddNewEntityEvent;
import com.damintsev.common.event.SaveNewEntityEvent;
import com.damintsev.common.event.SaveNewEntityHandler;
import com.damintsev.common.utils.Dialogs;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;

/**
 * User: adamintsev
 * Date: 04.02.14
 */
public class TreeAnswerPresenter implements TreePanelView.Presenter<TreeItem> {

    private static final String BASE_URL = "answer/";
    private TreePanelView<TreeItem> view;
    private boolean contentLoaded = false;

    public TreeAnswerPresenter(TreePanelView<TreeItem> view) {
        this.view = view;
        view.setPresenter(this);
        EventBus.get().addHandler(SaveNewEntityEvent.TYPE, new SaveNewEntityHandler() {
            @Override
            public void onEvent(SaveNewEntityEvent event) {
                loadRootElements();
            }
        });
    }

    @Override
    public void onEntitySelected(TreeItem selectedEntity) {
        if(selectedEntity instanceof Answer)
            History.newItem(BASE_URL + selectedEntity.getId().toString());
    }

    @Override
    public void addEntity(TreeItem selected) {
        if(selected instanceof Topic)
            EventBus.get().fireEvent(new AddNewEntityEvent(selected));
        else
            Dialogs.alert("Вы должны выбрать корневой элемент");
    }

    @Override
    public void removeEntity(final TreeItem selected) {
        if(selected instanceof Answer)
            RpcService.instance.removeAnswer(selected.getId(), new Callback<Void>() {
                @Override
                protected void onFinish(Void result) {
                    Dialogs.message("Удаление произведено успешно", new Runnable() {
                        @Override
                        public void run() {
                            view.removeEntity(selected.getStringId());
                            EventBus.get().fireEvent(new AddNewEntityEvent());
                        }
                    });

                }
            });
    }

    @Override
    public void loadRootElements() {
        RpcService.instance.loadMenuItems(new Callback<List<TreeNode<TreeItem>>>() {
            @Override
            protected void onFinish(List<TreeNode<TreeItem>> result) {
                view.setRootNodes(result);
                contentLoaded = true;
            }
        });
    }

    @Override
    public Widget asWidget() {
        return view.asWidget();
    }

    @Override
    public boolean isContentLoaded() {
        return contentLoaded;
    }
}
