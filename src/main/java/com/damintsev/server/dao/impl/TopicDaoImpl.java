package com.damintsev.server.dao.impl;

import com.damintsev.common.entity.Topic;
import com.damintsev.server.dao.TopicDao;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * User: adamintsev
 * Date: 05.02.14
 */
@Component
public class TopicDaoImpl implements TopicDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Topic> getListTopic() {
        return (List<Topic>)em.createQuery("SELECT t FROM Topic t").getResultList();
    }
}
