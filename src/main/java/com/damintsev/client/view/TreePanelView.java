package com.damintsev.client.view;

import com.damintsev.common.entity.TreeItem;
import com.damintsev.common.entity.TreeNode;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
public interface TreePanelView<T extends TreeItem> extends View {

    interface Presenter<T> extends com.damintsev.client.presenter.Presenter {
        void onEntitySelected(T selectedEntity);
        void addEntity();
        void removeEntity(T selected);
        Widget asWidget();
        void loadRootElements();

        boolean isContentLoaded();
    }

    void setRootNodes(List<TreeNode<T>> nodes);
    void setPresenter(Presenter<T> presenter);
    Widget asWidget();
}
