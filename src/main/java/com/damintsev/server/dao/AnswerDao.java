package com.damintsev.server.dao;

/**
 * User: adamintsev
 * Date: 05.02.14
 * //todo написать комментарии
 */

import com.damintsev.common.entity.Answer;

import java.util.List;

/**
 * Dao layer to work with Answer entities
 */
public interface AnswerDao {

    /**
     * Return all Answer entities
     * @return
     */
    List<Answer> getListAnswer();

    Answer getById(Object id);
}
