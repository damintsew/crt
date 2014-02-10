package com.damintsev.common.entity;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.persistence.*;

/**
 * User: adamintsev
 * Date: 04.02.14
 */
@javax.persistence.Entity
@Table(name = "entities_answers")
public class EntityAnswer implements IsSerializable {

    @Id
    private Long id;

    @JoinColumn(name = "answer_id")
//    @ManyToMany
    @OneToOne
    private Answer answer;

    @JoinColumn(name = "entity_id")
//    @ManyToMany
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
