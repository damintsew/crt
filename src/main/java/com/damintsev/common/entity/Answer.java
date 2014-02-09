package com.damintsev.common.entity;

import com.google.gwt.user.client.rpc.GwtTransient;

import javax.persistence.*;
import java.util.List;

/**
 * @author Damintsev Andrey
 *         04.02.14.
 */
@javax.persistence.Entity
@Table(name = "answers")
public class Answer implements TreeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "question", length = 400)
    private String question;

    @Column(name = "answer")
    private String answer;

    @Column(name = "priority")
    private Float priority;

    @Column(name = "disabled")
    private Integer disabled;

    @JoinColumn(name = "topic_id")
    @ManyToOne
    private Topic topic;

//    @GwtTransient
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "entities_answers",
        joinColumns = {@JoinColumn(name = "answer_id", nullable = false)},
        inverseJoinColumns = {@JoinColumn(name = "entity_id", nullable = false)})
    private List<Entity> entities;

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

    public List<Entity> getEntities() {
//        if (!Hibernate.isInitialized(entities)) return null;
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
}
