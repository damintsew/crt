package com.damintsev.server.logic.impl;

import com.damintsev.common.entity.Topic;
import com.damintsev.server.dao.TopicDao;
import com.damintsev.server.logic.BusinessLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Topic> getListTopics() {
        return topicDao.getListTopic();
    }
}
