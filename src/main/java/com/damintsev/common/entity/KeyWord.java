package com.damintsev.common.entity;

import javax.persistence.*;

/**
 * User: adamintsev
 * Date: 04.02.14
 * //todo написать комментарии
 */

@javax.persistence.Entity
@Table(name = "keywords")
public class KeyWord {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "value", length = 40)
    private String value;

    @Column(name = "unnormalized")
    private Integer unnormalized;

    @JoinColumn
    @OneToOne
    private Entity entity;

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

    public Boolean getUnnormalized() {
        return unnormalized != null && unnormalized == 0;
    }

    public void setUnnormalized(Integer unnormalized) {
        this.unnormalized = unnormalized;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
