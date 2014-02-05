package com.damintsev.server.dao.impl;

import com.damintsev.common.entity.Answer;
import com.damintsev.server.dao.AnswerDao;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * User: adamintsev
 * Date: 05.02.14
 * //todo написать комментарии
 */
@Component
public class AnswerDaoImpl implements AnswerDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Answer> getListAnswer() {
        return (List<Answer>)em.createQuery("SELECT a FROM Answer a").getResultList();
    }
}
