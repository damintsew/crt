package com.damintsev.client.service;

import com.damintsev.client.entity.UiAnswer;
import com.damintsev.common.entity.*;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface ServerConnectionAsync {

    void loadEntities(AsyncCallback<List<Entity>> async);

    void loadMenuItems(AsyncCallback<List<TreeNode<TreeItem>>> async);

    void loadUiAnswerById(Long answer, AsyncCallback<UiAnswer> async);

    void loadAnswerById(Long answer, AsyncCallback<Answer> async);
}
