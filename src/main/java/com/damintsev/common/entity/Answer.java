package com.damintsev.common.entity;

import javax.persistence.*;

/**
 * @author Damintsev Andrey
 *         04.02.14.
 */
@Entity
@Table(name = "answer")
public class Answer {

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

//    pri
}
