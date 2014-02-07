package com.damintsev.client.view;

import com.damintsev.client.presenter.AnswerFormPresenter;
import com.damintsev.common.entity.Answer;
import com.damintsev.common.entity.EntityAnswer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;

import java.util.List;

/**
 * User: adamintsev
 * Date: 06.02.14
 * //todo написать комментарии
 */
public class AnswerFormViewImpl implements AnswerFormView {

    @UiTemplate("AnswerFormView.ui.xml")
    interface Binder extends UiBinder<Widget, AnswerFormViewImpl> {
    }

    private static Binder uiBinder = GWT.create(Binder.class);
    private AnswerFormPresenter answerFormPresenter;

    @UiField
    ContentPanel contentPanel;
    @UiField
    TextArea answerText;
    @UiField
    TextField typeQuestion;

    public AnswerFormViewImpl() {
        uiBinder.createAndBindUi(this);
    }

    @Override
    public void setPresenter(AnswerFormPresenter answerFormPresenter) {
        this.answerFormPresenter = answerFormPresenter;
    }

    @Override
    public IsWidget asWidget() {
        return contentPanel;
    }

    @Override
    public void setEntitiesAnswer(List<EntityAnswer> entityAnswer) {
//todo        setAnswer(entityAnswer.getAnswer());
    }

    private void setPanelHeader(String text) {
        contentPanel.setHeadingText(text);
    }

    public void setAnswer(Answer answer) {
        setPanelHeader(answer.getName());
        answerText.setValue(answer.getName());
        typeQuestion.setValue(answer.getQuestion());
    }
}
