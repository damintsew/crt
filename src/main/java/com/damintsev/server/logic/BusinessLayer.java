package com.damintsev.server.logic;

/**
 * User: adamintsev
 * Date: 05.02.14
 */

import com.damintsev.common.entity.Topic;

import java.util.List;

/**
 * BusinessLayer layer
 */
public interface BusinessLayer {

    /**
     * Return list of all Topics entities
     * @return
     */
      List<Topic> getListTopics();
}