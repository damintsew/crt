package com.damintsev.server.dao.impl;

import com.damintsev.common.entity.Answer;
import com.damintsev.server.dao.AnswerDao;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * User: adamintsev
 * Date: 05.02.14
 * //todo написать комментарии
 */
@Component
public class AnswerDaoImpl extends DomainDaoImpl<Answer> implements AnswerDao {

    @PersistenceContext
    private EntityManager em;


    public AnswerDaoImpl() {
        super(Answer.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Answer> getListAnswer() {
        return (List<Answer>)em.createQuery("SELECT a FROM Answer a").getResultList();
    }

    /**
     * {@inheritDoc}
     */
    public Answer getById(Long id) {
        Query query = em.createQuery("SELECT a FROM Answer a " +
                "JOIN FETCH a.entities WHERE a.id = :id");
        query.setParameter("id", id);
        return (Answer) query.getSingleResult();
    }
}
