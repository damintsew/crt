package com.damintsev.server.servlet;

import com.damintsev.client.service.ServerConnection;
import com.damintsev.common.entity.Entity;
import com.damintsev.common.entity.TreeItem;
import com.damintsev.common.entity.TreeNode;
import com.damintsev.server.logic.BusinessLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    public List<TreeNode<TreeItem>> loadMenuItems() {
        return business.getListTreeItems();
    }
}
