package com.damintsev.client.view;

import com.damintsev.client.presenter.AnswerFormPresenter;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * User: adamintsev
 * Date: 06.02.14
 * //todo написать комментарии
 */
public interface AnswerFormView extends View {

    void setPresenter(AnswerFormPresenter answerFormPresenter);

    IsWidget asWidget();

    interface Presenter {

        IsWidget asWidget();
    }

}
