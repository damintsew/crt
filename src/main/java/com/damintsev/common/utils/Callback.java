package com.damintsev.common.utils;

import com.damintsev.common.exception.CustomException;
import com.damintsev.common.utils.Dialogs;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * User: Damintsev Andrey
 * Date: 21.10.13
 * Time: 21:04
 */

/**
 * Uses to reduce code. Class show alert box when caught exception
 *
 * @param <T>
 */
public abstract class Callback<T> implements AsyncCallback<T> {

    @Override
    public void onFailure(Throwable caught) {
        if (caught instanceof CustomException)
            Dialogs.alert(caught.getMessage());
        else
            Dialogs.alert("Произошла ошибка при выполнении запроса: " + caught.getMessage());
    }

    @Override
    public void onSuccess(T result) {
        onFinish(result);
    }

    /**
     * Called after success executing request
     * @param result
     */
    protected abstract void onFinish(T result);
}
