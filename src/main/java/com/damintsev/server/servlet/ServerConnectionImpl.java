package com.damintsev.server.servlet;

import com.damintsev.client.entity.UiAnswer;
import com.damintsev.client.service.ServerConnection;
import com.damintsev.common.entity.*;
import com.damintsev.server.logic.BusinessLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Damintsev Andrey
 * Date: 06.10.13
 * Time: 11:24
 */
@Service("ServerConnection")
public class ServerConnectionImpl implements ServerConnection {

    @Autowired
    private BusinessLayer business;

    @Override
    public List<Entity> loadEntities() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TreeNode<TreeItem>> loadMenuItems() {
        return business.getListTreeItems();
    }

    @Override
    public UiAnswer loadUiAnswerById(Long answerId) {
        return null;
//        return business.getAnswerById(answerId);
    }

    @Override
    public Answer loadAnswerById(Long answer) {
        Answer a = business.getAnswerById(answer);
        System.err.println("FUCKU=" + a.getEntities());
        return a;
//        return business.getAnswerById(answer);
    }
}
