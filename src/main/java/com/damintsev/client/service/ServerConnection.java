package com.damintsev.client.service;

import com.damintsev.common.entity.*;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.Collection;
import java.util.List;

/**
 * User: Damintsev Andrey
 * Date: 06.10.13
 * Time: 11:23
 */
@RemoteServiceRelativePath("ServerConnection")
public interface ServerConnection extends RemoteService {

    void test();

    List<Entity> loadEntities();

    List<TreeNode<TreeItem>> loadMenuItems();

    List<EntityAnswer> loadEntitiesByAnswerId(Long asnwerId);

    Answer loadAnswerById(Long answer);
}
