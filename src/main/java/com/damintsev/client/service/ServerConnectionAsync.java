package com.damintsev.client.service;

import com.damintsev.common.Callback;
import com.damintsev.common.entity.*;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * Async interaface for GWT Rpc calls
 */
public interface ServerConnectionAsync {

    void loadMenuItems(AsyncCallback<List<TreeNode<TreeItem>>> async);

    void loadAnswerById(Long answer, AsyncCallback<Answer> async);

    void getListKillerPhraseByAnswerId(Long answerId, AsyncCallback<List<KillerPhrase>> async);

    void removeAnswer(Long id, AsyncCallback<Void> async);

    void saveAnswer(Answer answer, AsyncCallback<Long> async);

    void saveKillerFrases(List<KillerPhrase> list, AsyncCallback<Void> async);
}
