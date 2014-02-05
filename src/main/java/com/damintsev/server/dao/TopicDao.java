package com.damintsev.server.dao;

/**
 * User: adamintsev
 * Date: 05.02.14
 */

import com.damintsev.common.entity.Topic;

import java.util.List;

/**
 * Retrieving objects
 */
public interface TopicDao {

    /**
     * Return list Topic entities
     * @return
     */
    List<Topic> getListTopic();
}
