package com.damintsev.server.dao.impl;

import com.damintsev.common.entity.Answer;
import com.damintsev.common.entity.KillerPhrase;
import com.damintsev.common.entity.Topic;
import com.damintsev.server.dao.AnswerDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
 */
@Component
public class AnswerDaoImpl implements AnswerDao {
    
    private static final Logger logger = Logger.getLogger(AnswerDaoImpl.class);

    @Autowired
    private DataSource dataSource;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Answer> getListAnswer() {
        List<Answer> answerList = new ArrayList<>();
        String sql = "SELECT a.id," +
                "    a.name," +
                "    a.question," +
                "    a.answer," +
                "    a.priority," +
                "    a.disabled," +
                "    a.action," +
                "    t.id," +
                "    t.name " +
                "FROM answers a " +
                "INNER JOIN topics t " +
                "ON t.id = a.topic_id ";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmnt = connection.prepareStatement(sql)) {
            ResultSet resultSet = stmnt.executeQuery();
            while (resultSet.next()) {
                Answer answer = new Answer();
                answer.setId(resultSet.getLong("a.id"));
                answer.setName(resultSet.getString("a.name"));
                answer.setQuestion(resultSet.getString("a.question"));
                answer.setAnswer(resultSet.getString("a.answer"));
                answer.setPriority(resultSet.getFloat("a.priority"));
                answer.setDisabled(resultSet.getInt("a.disabled"));
                Topic topic = new Topic();
                topic.setId(resultSet.getLong("t.id"));
                topic.setName(resultSet.getString("t.name"));
                answer.setTopic(topic);
                answerList.add(answer);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
        return answerList;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public Answer getById(Long id) {
        Answer answer = null;
        String sql = "SELECT a.id," +
                "    a.name," +
                "    a.question," +
                "    a.answer," +
                "    a.priority," +
                "    a.disabled," +
                "    a.action," +
                "    t.id," +
                "    t.name " +
                "FROM answers a " +
                "INNER JOIN topics t " +
                "ON t.id = a.topic_id " +
                "WHERE a.id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmnt = connection.prepareStatement(sql)) {
            stmnt.setLong(1, id);
            ResultSet resultSet = stmnt.executeQuery();
            if (resultSet.next()) {
                answer = new Answer();
                answer.setId(resultSet.getLong("a.id"));
                answer.setName(resultSet.getString("a.name"));
                answer.setQuestion(resultSet.getString("a.question"));
                answer.setAnswer(resultSet.getString("a.answer"));
                answer.setPriority(resultSet.getFloat("a.priority"));
                answer.setDisabled(resultSet.getInt("a.disabled"));
                Topic topic = new Topic();
                topic.setId(resultSet.getLong("t.id"));
                topic.setName(resultSet.getString("t.name"));
                answer.setTopic(topic);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
        return answer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<KillerPhrase> getListKillerPhrase(Long answerId) {
        List<KillerPhrase> list = new ArrayList<>();
        String sql = "SELECT * FROM killerphrases where answer_id = ?";
        try (Connection connection = dataSource.getConnection();
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
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeAnswer(Long id) {
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            String sql = "DELETE FROM killerphrases WHERE answer_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setLong(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                logger.error(e.getMessage(),e);
                throw new RuntimeException(e);
            }

            sql = "SELECT entity_id FROM entities_answers WHERE answer_id = ?";
            List<Long> idToRemove = new ArrayList<>();
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setLong(1, id);
                ResultSet resultSet = stmt.executeQuery();
                while (resultSet.next())
                    idToRemove.add(resultSet.getLong("entity_id"));
                resultSet.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(),e);
                throw new RuntimeException(e);
            }

            sql = "DELETE FROM entities_answers WHERE answer_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setLong(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                logger.error(e.getMessage(),e);
                throw new RuntimeException(e);
            }

            if (idToRemove.size() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("DELETE FROM entities WHERE id in (");
                for (int i = 0; i < idToRemove.size(); i++) {
                    sb.append("?");
                    sb.append((i == idToRemove.size() - 1) ? ")" : ",");
                }
                try (PreparedStatement stmt = connection.prepareStatement(sb.toString())) {
                    for (int i = 0; i < idToRemove.size(); i++) {
                        stmt.setLong((i + 1), idToRemove.get(i));
                    }
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    logger.error(e.getMessage(),e);
                    throw new RuntimeException(e);
                }
            }

            sql = "DELETE FROM answers WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setLong(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                logger.error(e.getMessage(),e);
                throw new RuntimeException(e);
            }
            connection.commit();
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long saveAnswer(Answer answer) {
        String sql = "INSERT INTO answers (id, name, question, answer, priority, disabled, topic_id)" +
                " values (?,?,?,?,?,?,?) " +
                " ON DUPLICATE KEY UPDATE name = VALUES(name), question = VALUES(question)," +
                "answer = VALUES(answer), priority = VALUES(priority), topic_id = VALUES(topic_id)," +
                "disabled = VALUES(disabled), action = VALUES(action)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmnt = connection.prepareStatement(sql)) {
            stmnt.setLong(1, answer.getId());
            stmnt.setString(2, answer.getName());
            stmnt.setString(3, answer.getQuestion());
            stmnt.setString(4, answer.getAnswer());
            stmnt.setFloat(5, answer.getPriority());
            stmnt.setInt(6, answer.getDisabled());
            stmnt.setLong(7, answer.getTopic().getId());
            stmnt.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Topic> getListTopic() {
        List<Topic> topicList = new ArrayList<>();
        String sql = "SELECT  t.id,t.name FROM topics t";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmnt = connection.prepareStatement(sql)) {
            ResultSet resultSet = stmnt.executeQuery();
            while (resultSet.next()) {
                Topic topic = new Topic();
                topic.setId(resultSet.getLong("t.id"));
                topic.setName(resultSet.getString("t.name"));
                topicList.add(topic);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
        return topicList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveKillerPhrases(List<KillerPhrase> killerPhrases) {
        String sql = "INSERT INTO killerphrases (id,value,answer_id) VALUES (?,?,?)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement stmnt = connection.prepareStatement(sql)){
            for(KillerPhrase phrase : killerPhrases) {
                stmnt.setLong(1, phrase.getId());
                stmnt.setString(2, phrase.getValue());
                stmnt.setLong(3, phrase.getAnswer().getId());
                stmnt.addBatch();
            }
            stmnt.executeBatch();
        }catch (SQLException e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }
}
