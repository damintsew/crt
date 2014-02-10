package com.damintsev.client;

import com.damintsev.common.utils.EventBus;
import com.damintsev.common.utils.async.Async;
import com.damintsev.common.utils.async.AsyncTask;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.DialogBox;

/**
 * Initializes ExceptionHandler
 */
public class MainGWT implements EntryPoint {

    public void onModuleLoad() {
        //cughting any JS exceptions
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
                new MainView();
                SimpleHistoryManager historyManager = new SimpleHistoryManager(EventBus.get());
                History.newItem("answer");
            }
        });
    }
}


