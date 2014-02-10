package com.damintsev.server.dao;

/**
 * User: adamintsev
 * Date: 05.02.14
 */

import com.damintsev.common.entity.Answer;
import com.damintsev.common.entity.KillerPhrase;
import com.damintsev.common.entity.Topic;

import java.util.List;

/**
 * Dao layer to work with UiAnswer entities
 */
public interface AnswerDao {

    /**
     * Return all Answer entities (without mapping Entity)
     * @return
     */
    List<Answer> getListAnswer();

    /**
     * Retunt fully information of Answer (with mapping Entity)
     * @param id
     * @return
     */
    Answer getById(Long id);

    /**
     * Returns List of KillerPhrases for selected Answer
     * @param answerId
     * @return
     */
    List<KillerPhrase> getListKillerPhrase(Long answerId);

    /**
     * Remove answer entity
     * @param id
     */
    void removeAnswer(Long id);

    /**
     * Save answer entity
     * @param answer
     * @return
     */
    Long saveAnswer(Answer answer);

    /**
     * Returns all Topic entities
     * @return
     */
    List<Topic> getListTopic();

    /**
     * Save list KillerPhrases
     * @param killerPhrases
     */
    void saveKillerPhrases(List<KillerPhrase> killerPhrases);
}
