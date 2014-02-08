package com.damintsev.client.entity;

import java.util.List;

/**
 * @author Damintsev Andrey
 *         04.02.14.
 */
public class UiAnswer implements TreeItem {

    private Long id;
    private String name;
    private String question;
    private String answer;
    private Float priority;
    private Integer disabled;
    private Topic topic;
    private List<UiEntity> entities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Float getPriority() {
        return priority;
    }

    public void setPriority(Float priority) {
        this.priority = priority;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topics) {
        this.topic = topics;
    }

    @Override
    public String getStringId() {
        return this.getClass().getName() + id;
    }

    public List<UiEntity> getEntities() {
//        if (!Hibernate.isInitialized(entities)) return null;
        return entities;
    }

    public void setEntities(List<UiEntity> entities) {
        this.entities = entities;
    }
}
