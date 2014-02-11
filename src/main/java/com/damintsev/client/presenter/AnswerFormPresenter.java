package com.damintsev.client.presenter;

import com.damintsev.common.utils.EventBus;
import com.damintsev.client.service.RpcService;
import com.damintsev.client.view.AnswerFormView;
import com.damintsev.common.utils.Callback;
import com.damintsev.common.entity.Answer;
import com.damintsev.common.entity.KillerPhrase;
import com.damintsev.common.entity.Topic;
import com.damintsev.common.event.AddNewEntityEvent;
import com.damintsev.common.event.AddNewEntityHandler;
import com.damintsev.common.event.SaveNewEntityEvent;
import com.google.gwt.user.client.ui.IsWidget;

import java.util.ArrayList;
import java.util.List;

/**
 * User: adamintsev
 * Date: 06.02.14
 */

/**
 * Presenter for AnswerForm
 */
public class AnswerFormPresenter implements AnswerFormView.Presenter {

    private AnswerFormView answerFormView;

    public AnswerFormPresenter(AnswerFormView answerFormView) {
        this.answerFormView = answerFormView;
        answerFormView.setPresenter(this);
        EventBus.get().addHandler(AddNewEntityEvent.TYPE, new AddNewEntityHandler() {
            @Override
            public void onEvent(AddNewEntityEvent event) {
                Answer answer = new Answer();
                answer.setTopic((Topic) event.getItem());
                AnswerFormPresenter.this.answerFormView.setAnswer(answer);
                AnswerFormPresenter.this.answerFormView.setKillerPhrases(new ArrayList<KillerPhrase>());
            }
        });
    }

    @Override
    public IsWidget asWidget() {
        return answerFormView.asWidget();
    }

    @Override
    public void loadEntity(Long answerId) {
        if (answerId == null){
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
        //This method need to be optimize (visually) using a queue that call Rpc methods
        RpcService.instance.saveAnswer(answer, new Callback<Long>() {
            @Override
            protected void onFinish(Long result) {
                answer.setId(result);
                EventBus.get().fireEvent(new SaveNewEntityEvent(answer));
                List<KillerPhrase> killerPhrases = answerFormView.getKillerFrases();
                for (KillerPhrase phrase : killerPhrases) {
                    phrase.setAnswer(answer);
                }
                RpcService.instance.saveKillerPhrases(killerPhrases, new Callback<Void>() {
                    @Override
                    protected void onFinish(Void result) {
                    }
                });
            }
        });

    }
}
