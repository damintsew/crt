package com.damintsev.server.logic.impl;

import com.damintsev.common.entity.*;
import com.damintsev.common.utils.TreeNode;
import com.damintsev.server.dao.AnswerDao;
import com.damintsev.server.logic.BusinessLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * User: adamintsev
 * Date: 05.02.14
 */

/**
 * Implementation of BusinessLayer
 */
@Component
public class BusinessLayerImpl implements BusinessLayer {

    @Autowired
    private AnswerDao answerDao;


    /**
     * {@inheritDoc}
     */
    @Override
    public List<TreeNode<TreeItem>> getListTreeItems() {
        Map<Long, TreeNode<TreeItem>> nodeMap = new HashMap<>();
        for(Topic topic : answerDao.getListTopic()) {
            nodeMap.put(topic.getId(), new TreeNode<TreeItem>(topic));
        }
        for(Answer answer : answerDao.getListAnswer()) {
            answer.getEntities();
            TreeNode<TreeItem> item = nodeMap.get(answer.getTopic().getId());
            if(item == null) {
                item = new TreeNode<TreeItem>(answer.getTopic());
                nodeMap.put(answer.getTopic().getId(), item);
            }
            item.appendChildren(new TreeNode<TreeItem>(answer));
        }
        return new ArrayList<TreeNode<TreeItem>>(nodeMap.values());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Answer getAnswerById(Long answerId) {
        return answerDao.getById(answerId);
    }

    @Override
    public List<KillerPhrase> getListKillerPhraseByAnswerId(Long answerId) {
        return answerDao.getListKillerPhrase(answerId);
    }

    @Override
    public void removeAnswer(Long id) {
        answerDao.removeAnswer(id);
    }

    @Override
    public Long saveAnswer(Answer answer) {
        return answerDao.saveAnswer(answer);
    }
}
