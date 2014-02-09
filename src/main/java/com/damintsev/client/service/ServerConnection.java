package com.damintsev.client.service;

import com.damintsev.common.Callback;
import com.damintsev.common.entity.*;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * User: Damintsev Andrey
 * Date: 06.10.13
 * Time: 11:23
 */

/**
 * Syncronous interaface to server gwt rpc
 */
@RemoteServiceRelativePath("ServerConnection")
public interface ServerConnection extends RemoteService {

    /**
     * Loads all tree menu items
     * @return
     */
    List<TreeNode<TreeItem>> loadMenuItems();

    /**
     * Load detailed information for answer
     * @param answer
     * @return
     */
    Answer loadAnswerById(Long answer);

    /**
     * Load list KillerFrase entities for sekected Answer id
     * @param answerId
     * @return
     */
    List<KillerPhrase> getListKillerPhraseByAnswerId(Long answerId);

    /**
     * Removes Answer
     * @param id
     */
    void removeAnswer(Long id);

    /**
     * Save answer
     * @param answer
     * @return
     */
    Long saveAnswer(Answer answer);

    /**
     * Save List of killer frases
     * @param list
     */
    void saveKillerFrases(List<KillerPhrase> list);
}
