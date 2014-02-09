package com.damintsev.common.entity;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
@javax.persistence.Entity
@Table(name = "entities")
public class Entity implements IsSerializable, Serializable {

    @Id
    private Long id;

    @Column(name = "name", length = 40)
    private String name;

    @Column(name = "title", length = 40)
    private String title;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "entities")
//    private List<Answer> answers;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public List<Answer> getAnswers() {
//        return answers;
//    }

//    public void setAnswers(List<Answer> answers) {
//        this.answers = answers;
//    }
}