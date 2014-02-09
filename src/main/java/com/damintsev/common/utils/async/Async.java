package com.damintsev.common.utils.async;

import com.damintsev.common.exception.CustomException;
import com.damintsev.common.utils.Dialogs;
import com.google.gwt.core.client.RunAsyncCallback;

/**
 * User: Damintsev Andrey
 */

/**
 * Uses to tell gwt compiler to create separate file
 */
public class Async {

    /**
     * Code in AsyncTask will be separeted to another file
     *
     * @param task
     */
    public static void runAsync(final AsyncTask task) {
        com.google.gwt.core.client.GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                if (reason instanceof CustomException)
                    Dialogs.alert(reason.getMessage());
                else
                    Dialogs.alert("Произошла ошибка при выполнении запроса: " + reason.getMessage());
            }

            @Override
            public void onSuccess() {
                task.onSuccess();
            }
        });
    }
}
