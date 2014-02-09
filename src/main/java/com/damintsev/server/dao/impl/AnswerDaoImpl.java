package com.damintsev.server.dao.impl;

import com.damintsev.common.entity.Answer;
import com.damintsev.common.entity.KillerPhrase;
import com.damintsev.server.dao.AnswerDao;
import com.sun.org.apache.regexp.internal.recompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: adamintsev
 * Date: 05.02.14
 * //todo написать комментарии
 */
@Component
public class AnswerDaoImpl extends DomainDaoImpl<Answer> implements AnswerDao {

    @Autowired
    private DataSource dataSource;

    public AnswerDaoImpl() {
        super(Answer.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<Answer> getListAnswer() {
        List<Answer> newAnswers = new ArrayList<>();
        Query query = em.createQuery("SELECT a FROM Answer a ");
        for(Answer answer : (List<Answer>)query.getResultList()) {
            answer = mapper.map(answer, Answer.class);
            newAnswers.add(answer);
        }
        return newAnswers;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public Answer getById(Long id) {
        Query query = em.createQuery("SELECT a FROM Answer a " +
                "JOIN FETCH a.entities WHERE a.id = :id");
        query.setParameter("id", id);
        return mapper.map(query.getSingleResult(), Answer.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<KillerPhrase> getListKillerPhrase(Long answerId) {
        List<KillerPhrase> list = new ArrayList<>();
        String sql = "SELECT * FROM killerphrases where answer_id = ?";
        try(Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, answerId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                KillerPhrase killerPhrase = new KillerPhrase();
                killerPhrase.setId(resultSet.getLong("id"));
                killerPhrase.setValue(resultSet.getString("value"));
                list.add(killerPhrase);
            }
            resultSet.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
     }
}
