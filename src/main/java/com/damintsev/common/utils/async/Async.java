package com.damintsev.common.utils.async;

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
     * @param task
     */
    public static void runAsync(final AsyncTask task) {
        com.google.gwt.core.client.GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                //Todo change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSuccess() {
                task.onSuccess();
            }
        });
    }
}
