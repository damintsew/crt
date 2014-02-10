package com.damintsev.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: adamintsev
 * Date: 04.02.14
 */
@Entity
@Table(name = "topics")
public class Topic implements TreeItem {

    @Id
    private Long id;

    @Column(name = "name", length = 40)
    private String name;

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

    @Override
    public String getStringId() {
        return this.getClass().getName() + id;
    }
}
