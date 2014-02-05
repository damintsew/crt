package com.damintsev.server.servlet;

import com.damintsev.client.service.ServerConnection;
import com.damintsev.common.entity.Entity;
import com.damintsev.common.entity.Topic;
import com.damintsev.server.logic.BusinessLayer;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void test() {
        System.out.println("FUCK U!!!!!");
    }

    @Override
    public List<Entity> loadEntities() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Topic> loadTopics() {
        return business.getListTopics();
    }
}
