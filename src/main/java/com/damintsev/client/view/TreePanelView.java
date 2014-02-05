package com.damintsev.client.view;

import com.damintsev.common.entity.Entity;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
public interface TreePanelView<T> extends View {

    void setRootNodes(List<T> rootNodes);

    interface Presenter<T> {
        void onEntitySelected(T selectedEntity);
        void addEntity();
        void removeEntity(T selected);
        Widget asWidget();
        void loadRootElements();
    }

    void setPresenter(Presenter<T> presenter);
    Widget asWidget();
    void setData(List<T> data);
}
