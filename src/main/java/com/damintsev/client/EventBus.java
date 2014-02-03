package com.damintsev.client;

import com.google.gwt.event.shared.HandlerManager;

/**
 * User: adamintsev
 * Date: 20.12.13
 * EventBus bind event handlers and fire them
 */
public class EventBus {

    private static HandlerManager instance;

    public static HandlerManager get() {
        if (instance == null) instance = new HandlerManager(null);
        return instance;
    }
}
