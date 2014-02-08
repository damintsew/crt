package com.damintsev.client.presenter;

import com.damintsev.client.service.RpcService;
import com.damintsev.client.view.AnswerFormView;
import com.damintsev.common.Callback;
import com.damintsev.common.entity.Answer;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * User: adamintsev
 * Date: 06.02.14
 * //todo написать комментарии
 */
public class AnswerFormPresenter implements AnswerFormView.Presenter, Presenter{

    private AnswerFormView answerFormView;

    public AnswerFormPresenter(AnswerFormView answerFormView) {
        this.answerFormView = answerFormView;
        answerFormView.setPresenter(this);
    }

    @Override
    public IsWidget asWidget() {
        return answerFormView.asWidget();
    }

    @Override
    public void loadEntity(Long answerId) {
        if(answerId == null)return;
        RpcService.instance.loadAnswerById(answerId, new Callback<Answer>() {
            @Override
            protected void onFinish(Answer result) {
                answerFormView.setAnswer(result);
            }
        });
    }
}
