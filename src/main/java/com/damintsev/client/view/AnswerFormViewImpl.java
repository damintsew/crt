package com.damintsev.client.view;

import com.damintsev.client.presenter.AnswerFormPresenter;
import com.damintsev.common.entity.Answer;
import com.damintsev.common.entity.Entity;
import com.damintsev.common.entity.KillerPhrase;
import com.damintsev.common.utils.AvalueProvider;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.button.ToolButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.editing.GridEditing;
import com.sencha.gxt.widget.core.client.grid.editing.GridInlineEditing;

import java.util.*;

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
    private Answer answer;

    @UiField
    ContentPanel contentPanel;
    @UiField
    TextArea answerText;
    @UiField
    TextField typeQuestion;
    @UiField
    VerticalLayoutContainer entityContainer;

    Grid<KillerPhrase> gridKillerFrases;

    public AnswerFormViewImpl() {
        uiBinder.createAndBindUi(this);
        initMapField();
    }

    private void initMapField() {
        ColumnConfig<KillerPhrase, String> valueColumn = new ColumnConfig<KillerPhrase, String>(new AvalueProvider<KillerPhrase, String>("value") {
            @Override
            public String getValue(KillerPhrase object) {
                return object.getValue();
            }

            @Override
            public void setValue(KillerPhrase object, String value) {
                object.setValue(value);
            }
        });
        valueColumn.setRowHeader(false);
        valueColumn.setWidth(500);
        List<ColumnConfig<KillerPhrase, ?>> columnModel = new ArrayList<ColumnConfig<KillerPhrase, ?>>(1);
        columnModel.add(valueColumn);
        gridKillerFrases = new Grid<KillerPhrase>(new ListStore<KillerPhrase>(new ModelKeyProvider<KillerPhrase>() {
            @Override
            public String getKey(KillerPhrase item) {
                return item.getId() == null?"null" : item.getId().toString();
            }
        }), new ColumnModel<KillerPhrase> (columnModel));
        GridEditing<KillerPhrase> gridEditing = new GridInlineEditing<KillerPhrase>(gridKillerFrases);
        gridEditing.addEditor(valueColumn, new TextField());
        ToolButton addButton = new ToolButton(ToolButton.PLUS);
        addButton.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                gridKillerFrases.getStore().add(new KillerPhrase());
            }
        });
        ContentPanel panel  = new ContentPanel();
        panel.setHeaderVisible(false);
        panel.add(gridKillerFrases);
        panel.addButton(new TextButton("Сохранить", new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                answerFormPresenter.save();
            }
        }));
        entityContainer.add(addButton, new VerticalLayoutContainer.VerticalLayoutData(-1, -1, new Margins(0,5,5,490)));
        entityContainer.add(panel, new VerticalLayoutContainer.VerticalLayoutData(1,300));
    }

    @Override
    public void setPresenter(AnswerFormPresenter answerFormPresenter) {
        this.answerFormPresenter = answerFormPresenter;
    }

    @Override
    public IsWidget asWidget() {
        return contentPanel;
    }

    private void setPanelHeader(String text) {
        contentPanel.setHeadingText(text);
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
        setPanelHeader(answer.getName());
        answerText.setValue(answer.getName());
        typeQuestion.setValue(answer.getQuestion());
        setEntities(answer.getEntities());
    }

    public void setEntities(List<Entity> entity) {
        //not yet implemented
    }

    public List<Entity> getEntities() {
        //not yet implemented
        return null;
    }

    @Override
    public void setKillerPhrases(List<KillerPhrase> killerPhrases) {
        gridKillerFrases.getStore().clear();
        gridKillerFrases.getStore().addAll(killerPhrases);
    }

    @Override
    public List<KillerPhrase> getKillerFrases() {
        return gridKillerFrases.getStore().getAll();
    }

    @Override
    public Answer getAnswer() {
        answer.setName(answerText.getValue());
        answer.setQuestion(typeQuestion.getValue());
        return answer;
    }
}
