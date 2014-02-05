package com.damintsev.common.entity;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */
@javax.persistence.Entity
@Table(name = "entities")
public class Entity implements IsSerializable {

    @Id
    private Long id;

    @Column(name = "name", length = 40)
    private String name;

    @Column(name = "title", length = 40)
    private String title;

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
}