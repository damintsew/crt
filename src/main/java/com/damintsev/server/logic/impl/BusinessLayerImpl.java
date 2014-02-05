package com.damintsev.server.logic.impl;

import com.damintsev.common.entity.Answer;
import com.damintsev.common.entity.Topic;
import com.damintsev.common.entity.TreeItem;
import com.damintsev.server.dao.AnswerDao;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<TreeItem> getListTreeItems() {
        List<TreeItem> items = new ArrayList<>();
        items.addAll(topicDao.getListTopic());
        items.addAll(answerDao.getListAnswer());
        return items;
    }
}
