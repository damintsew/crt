package com.damintsev.common.entity;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
@Entity
@Table(name = "killerphrase")
public class KillerPhrase {

    @Id
    private Long id;

    @Column(name = "value", length = 400)
    private String value;

    @JoinColumn(name = "answer_id")
    @OneToOne
    private Answer answer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
