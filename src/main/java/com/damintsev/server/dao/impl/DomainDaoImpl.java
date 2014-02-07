package com.damintsev.server.dao.impl;

import com.damintsev.server.dao.DomainDao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * User: adamintsev
 * Date: 07.02.14
 */

/**
 * Class work with CRUD operations
 * @param <T>
 */
public class DomainDaoImpl<T> implements DomainDao<T> {

    @PersistenceContext
    private EntityManager em;

    private Class<T> clazz;

    public DomainDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getById(Object id) {
        return em.find(clazz, id);
    }
}
