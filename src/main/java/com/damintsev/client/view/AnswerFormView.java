package com.damintsev.client.view;

import com.damintsev.client.presenter.AnswerFormPresenter;
import com.damintsev.common.entity.Answer;
import com.damintsev.common.entity.EntityAnswer;
import com.google.gwt.user.client.ui.IsWidget;

import java.util.List;

/**
 * User: adamintsev
 * Date: 06.02.14
 * //todo написать комментарии
 */
public interface AnswerFormView extends View {

    void setPresenter(AnswerFormPresenter answerFormPresenter);

    IsWidget asWidget();

    void setEntitiesAnswer(List<EntityAnswer> entityAnswer);

    void setAnswer(Answer answer);

    interface Presenter extends com.damintsev.client.presenter.Presenter {

        IsWidget asWidget();

        void loadEntity(Long answerId);
    }

}
