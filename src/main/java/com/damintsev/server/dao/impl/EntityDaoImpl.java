package com.damintsev.server.dao.impl;

import com.damintsev.common.entity.EntityAnswer;
import com.damintsev.server.dao.EntityDao;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * User: adamintsev
 * Date: 07.02.14
 */
@Component
public class EntityDaoImpl implements EntityDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * {@inheritDoc}
     */
    public List<EntityAnswer> getEntitiesByAnswerId(Long answerId) {
        Query query = em.createQuery("SELECT e FROM EntityAnswer e WHERE e.answer.id = :answerId");
        query.setParameter("answerId", answerId);
        return (List<EntityAnswer> )query.getResultList();
    }
}
