package com.damintsev.client.entity;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.persistence.*;
import java.util.List;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
public class UiEntity implements IsSerializable {

    private Long id;
    private String name;
    private String title;
    private List<UiAnswer> answers;

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

    public List<UiAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<UiAnswer> answers) {
        this.answers = answers;
    }
}