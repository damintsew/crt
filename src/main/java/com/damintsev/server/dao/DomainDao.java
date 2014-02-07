package com.damintsev.server.dao;

/**
 * User: adamintsev
 * Date: 07.02.14
 * //todo написать комментарии
 */
public interface DomainDao<T> {

    /**
     * Returns obkect by his Id
     * @param id
     * @return
     */
    T getById(Object id);
}
