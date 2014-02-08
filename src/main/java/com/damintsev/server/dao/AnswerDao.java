package com.damintsev.server.dao;

/**
 * User: adamintsev
 * Date: 05.02.14
 * //todo написать комментарии
 */

import com.damintsev.common.entity.Answer;

import java.util.List;

/**
 * Dao layer to work with UiAnswer entities
 */
public interface AnswerDao {

    /**
     * Return all UiAnswer entities
     * @return
     */
    List<Answer> getListAnswer();

    Answer getById(Long id);
}
