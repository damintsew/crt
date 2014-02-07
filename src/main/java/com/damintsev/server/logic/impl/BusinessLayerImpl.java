package com.damintsev.server.logic.impl;

import com.damintsev.common.entity.*;
import com.damintsev.server.dao.AnswerDao;
import com.damintsev.server.dao.EntityDao;
import com.damintsev.server.dao.TopicDao;
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
    private TopicDao topicDao;

    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private EntityDao entityDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TreeNode<TreeItem>> getListTreeItems() {
        Map<Long, TreeNode<TreeItem>> nodeMap = new HashMap<>();
        for(Topic topic : topicDao.getListTopic()) {
            nodeMap.put(topic.getId(), new TreeNode<TreeItem>(topic));
        }
        for(Answer answer : answerDao.getListAnswer()) {
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
    public List<EntityAnswer> getEntitiesByAnswerId(Long asnwerId) {
        return entityDao.getEntitiesByAnswerId(asnwerId);
    }
}
