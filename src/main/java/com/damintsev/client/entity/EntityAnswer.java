package com.damintsev.client.entity;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.persistence.Entity;
import javax.persistence.*;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
@Entity
@Table(name = "entities_answers")
public class EntityAnswer implements IsSerializable {

    @Id
    private Long id;

    @JoinColumn(name = "answer_id")
//    @ManyToMany
    @OneToOne
    private UiAnswer answer;

    @JoinColumn(name = "entity_id")
//    @ManyToMany
    @OneToOne
    private UiEntity entity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UiAnswer getAnswer() {
        return answer;
    }

    public void setAnswer(UiAnswer answer) {
        this.answer = answer;
    }

    public UiEntity getEntity() {
        return entity;
    }

    public void setEntity(UiEntity entity) {
        this.entity = entity;
    }
}
