package com.damintsev.common.entity;

import javax.persistence.*;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
@javax.persistence.Entity
@Table(name = "entities_answer")
public class EntityAnswer {

    @Id
    private Long id;

    @JoinColumn
    @OneToOne
    private Answer answer;

    @JoinColumn
    @OneToOne
    private Entity entity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
