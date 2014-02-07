package com.damintsev.server.dao;

import com.damintsev.common.entity.EntityAnswer;

import java.util.List;

/**
 * User: adamintsev
 * Date: 07.02.14
 * //todo написать комментарии
 */
public interface EntityDao {

    List<EntityAnswer> getEntitiesByAnswerId(Long answerId);
}
