package com.damintsev.client.service;

import com.damintsev.common.entity.Entity;
import com.damintsev.common.entity.Topic;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

import java.util.List;

public interface ServerConnectionAsync {

    void test(AsyncCallback<Void> async);

    void loadEntities(AsyncCallback<List<Entity>> async);

    void loadTopics(AsyncCallback<List<Topic>> async);
}
