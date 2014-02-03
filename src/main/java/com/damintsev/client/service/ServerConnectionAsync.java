package com.damintsev.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

import java.util.List;

public interface ServerConnectionAsync {

    void test(AsyncCallback<Void> async);
}
