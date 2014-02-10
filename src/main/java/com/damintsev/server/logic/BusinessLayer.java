package com.damintsev.server.logic;

/**
 * User: adamintsev
 * Date: 05.02.14
 */

import com.damintsev.common.entity.*;
import com.damintsev.common.utils.TreeNode;

import java.util.List;

/**
 * BusinessLayer layer
 */
public interface BusinessLayer {

    /**
     * Return list of all Topics entities
     * @return
     */
    List<TreeNode<TreeItem>> getListTreeItems();

    /**
     * Return Answer entity by his Id
     * @param answerId
     * @return
     */
    Answer getAnswerById(Long answerId);

    /**
     * Get all KillerPhrase for Answer with desired id
     * @param answerId
     * @return
     */
    List<KillerPhrase> getListKillerPhraseByAnswerId(Long answerId);

    /**
     * Remove Answer entity
      * @param id
     */
    void removeAnswer(Long id);

    /**
     * Save answer entity
     * @param answer
     * @return new answer Id
     */
    Long saveAnswer(Answer answer);

    /**
     * Save list KillerPhrases
     * @param killerPhrases
     */
    void saveKillerPhrases(List<KillerPhrase> killerPhrases);
}
