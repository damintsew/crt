package com.damintsev.server.servlet;

import com.damintsev.client.service.ServerConnection;
import com.damintsev.common.entity.*;
import com.damintsev.server.logic.BusinessLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Damintsev Andrey
 * Date: 06.10.13
 * Time: 11:24
 */
@Service("ServerConnection")
public class ServerConnectionImpl implements ServerConnection {

    @Autowired
    private BusinessLayer business;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TreeNode<TreeItem>> loadMenuItems() {
        return business.getListTreeItems();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Answer loadAnswerById(Long answer) {
        return business.getAnswerById(answer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<KillerPhrase> getListKillerPhraseByAnswerId(Long answerId) {
        return business.getListKillerPhraseByAnswerId(answerId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeAnswer(Long id) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long saveAnswer(Answer answer) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveKillerFrases(List<KillerPhrase> list) {

    }
}
