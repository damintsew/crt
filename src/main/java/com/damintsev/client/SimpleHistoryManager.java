package com.damintsev.client;

import com.damintsev.common.event.ShowAnswerSectionEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;

import java.util.logging.Handler;

/**
 * @author Damintsev Andrey
 *         04.02.14.
 */
/**
 * Responds for work with history. Fires event if URL is changes
 */
public class SimpleHistoryManager implements ValueChangeHandler<String> {

    private HandlerManager handlerManager;

    public SimpleHistoryManager(HandlerManager handlerManager) {
        this.handlerManager = handlerManager;
        init();
    }

    /**
     * Bing history handler to this class
     */
    private void init() {
        History.addValueChangeHandler(this);
        History.fireCurrentHistoryState();
    }

    /**
     * Method calls when browser history changes
     * @param event
     */
    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        onTokenChanged(event.getValue());
    }

    /**
     * Parses input string and fires event
     * @param token
     */
    private void onTokenChanged(String token) {
        if (token.startsWith("answer") || token.equals("")) {
            Long id = parseId(token);
            handlerManager.fireEvent(new ShowAnswerSectionEvent(id));
        } else if (token.startsWith("entity")) {
            //Another form
        }
    }

    /**
     * Parse id from request
     * @param token
     * @return
     */
    private Long parseId(String token) {
        String []array = token.split("/");
        if(array.length == 2)
            return Long.valueOf(array[1]);
        return null;
    }
}
