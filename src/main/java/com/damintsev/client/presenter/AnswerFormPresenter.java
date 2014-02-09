package com.damintsev.client.presenter;

import com.damintsev.client.EventBus;
import com.damintsev.client.service.RpcService;
import com.damintsev.client.view.AnswerFormView;
import com.damintsev.common.Callback;
import com.damintsev.common.entity.Answer;
import com.damintsev.common.entity.KillerPhrase;
import com.damintsev.common.event.AddNewEntityEvent;
import com.google.gwt.user.client.ui.IsWidget;

import java.util.ArrayList;
import java.util.List;

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
        if (answerId == null) return;
        if (answerId == -1) {
            answerFormView.setAnswer(new Answer());
            answerFormView.setKillerPhrases(new ArrayList<KillerPhrase>());
        } else {
            RpcService.instance.loadAnswerById(answerId, new Callback<Answer>() {
                @Override
                protected void onFinish(Answer result) {
                    answerFormView.setAnswer(result);
                }
            });
            RpcService.instance.getListKillerPhraseByAnswerId(answerId, new Callback<List<KillerPhrase>>() {
                @Override
                protected void onFinish(List<KillerPhrase> result) {
                    answerFormView.setKillerPhrases(result);
                }
            });
        }
    }

    @Override
    public void save() {
        final Answer answer = answerFormView.getAnswer();
        //This method need to be optimize (visually) using a queue that call Rpc mmethods
        RpcService.instance.saveAnswer(answer, new Callback<Long>() {
            @Override
            protected void onFinish(Long result) {
                answer.setId(result);
                EventBus.get().fireEvent(new AddNewEntityEvent(answer));
                List<KillerPhrase> killerPhrases = answerFormView.getKillerFrases();
                for(KillerPhrase phrase : killerPhrases) {
                    phrase.setAnswer(answer);
                }
                RpcService.instance.saveKillerFrases(killerPhrases, new Callback<Void>() {
                    @Override
                    protected void onFinish(Void result) {
                    }
                });
            }
        });

    }
}
