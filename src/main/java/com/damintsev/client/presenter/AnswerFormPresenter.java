package com.damintsev.client.presenter;

import com.damintsev.client.view.AnswerFormView;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * User: adamintsev
 * Date: 06.02.14
 * //todo написать комментарии
 */
public class AnswerFormPresenter implements AnswerFormView.Presenter {

    private AnswerFormView answerFormView;

    public AnswerFormPresenter(AnswerFormView answerFormView) {
        this.answerFormView = answerFormView;
        answerFormView.setPresenter(this);
    }

    @Override
    public IsWidget asWidget() {
        return answerFormView.asWidget();
    }
}
