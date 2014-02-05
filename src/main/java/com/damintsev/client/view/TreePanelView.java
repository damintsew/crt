package com.damintsev.client.view;

import com.damintsev.common.entity.Entity;
import com.damintsev.common.entity.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.TreeStore;

import java.util.List;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
public interface TreePanelView<T extends TreeItem> extends View {

    interface Presenter<T> {
        void onEntitySelected(T selectedEntity);
        void addEntity();
        void removeEntity(T selected);
        Widget asWidget();
        void loadRootElements();
    }

    void setRootNodes(List<T> nodes);
    void setPresenter(Presenter<T> presenter);
    Widget asWidget();
}
