package com.damintsev.client.view;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
public interface TreePanelView<T> {

    interface Presenter<T> {
        void onEntitySelected(T selectedEntity);
        void addNewEntity();
    }

    void setPresenter(Presenter<T> presenter);
}
