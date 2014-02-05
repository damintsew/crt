package com.damintsev.client.service;

import com.damintsev.common.entity.Entity;
import com.damintsev.common.entity.Topic;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

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

    List<Topic> loadTopics();
}
