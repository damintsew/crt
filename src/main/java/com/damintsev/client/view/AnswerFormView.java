package com.damintsev.client.view;

import com.damintsev.client.presenter.AnswerFormPresenter;
import com.damintsev.common.entity.Answer;
import com.damintsev.common.entity.EntityAnswer;
import com.damintsev.common.entity.KillerPhrase;
import com.google.gwt.user.client.ui.IsWidget;

import java.util.List;

/**
 * User: adamintsev
 * Date: 06.02.14
 */

/**
 * AnswerFormView interface
 */
public interface AnswerFormView extends View {

    void setPresenter(AnswerFormPresenter answerFormPresenter);

    IsWidget asWidget();

    void setAnswer(Answer answer);

    void setKillerPhrases(List<KillerPhrase> killerPhrases);

    Answer getAnswer();

    List<KillerPhrase> getKillerFrases();

    interface Presenter extends com.damintsev.client.presenter.Presenter {

        IsWidget asWidget();

        void loadEntity(Long answerId);

        void save();
    }

}
