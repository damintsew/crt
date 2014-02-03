package com.damintsev.client;

import com.damintsev.client.service.Service;
import com.damintsev.common.event.StartEditEvent;
import com.damintsev.common.utils.Dialogs;
import com.damintsev.common.utils.async.Async;
import com.damintsev.common.utils.async.AsyncTask;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.RootPanel;

public class MainGWT implements EntryPoint {

    public void onModuleLoad() {
        GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
            public void onUncaughtException(Throwable throwable) {
                String text = "Uncaught exception: ";
                while (throwable != null) {
                    StackTraceElement[] stackTraceElements = throwable.getStackTrace();
                    text += throwable.toString() + "\n";
                    for (StackTraceElement stackTraceElement : stackTraceElements) {
                        text += "    at " + stackTraceElement + "\n";
                    }
                    throwable = throwable.getCause();
                    if (throwable != null) {
                        text += "Caused by: ";
                    }
                }
                DialogBox dialogBox = new DialogBox(true, false);
                DOM.setStyleAttribute(dialogBox.getElement(), "backgroundColor", "#ABCDEF");
                System.err.print(text);
                text = text.replaceAll(" ", "&nbsp;");
                dialogBox.setHTML("<pre>" + text + "</pre>");
                dialogBox.center();
            }
        });
        Scheduler.get().scheduleDeferred(new Command() {
            public void execute() {
                onModuleLoad2();
            }
        });
    }

    private void onModuleLoad2() {
        Async.runAsync(new AsyncTask() {
            @Override
            public void onSuccess() {
                EventBus.get();
//                RootPanel.get().add(UIRootPanel.get().getContent());
                Service.instance.test(new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {

                    }

                    @Override
                    public void onSuccess(Void result) {
                        Dialogs.alert("FUCK");

                    }
                });
            }
        });
    }
}


