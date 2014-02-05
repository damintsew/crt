package com.damintsev.client.service;

import com.damintsev.common.entity.Entity;
import com.damintsev.common.entity.Topic;
import com.damintsev.common.entity.TreeItem;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

import java.util.Collection;
import java.util.List;

public interface ServerConnectionAsync {

    void test(AsyncCallback<Void> async);

    void loadEntities(AsyncCallback<List<Entity>> async);

    void loadMenuItems(AsyncCallback<Collection<TreeItem>> async);
}
