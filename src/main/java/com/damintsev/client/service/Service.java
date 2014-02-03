package com.damintsev.client.service;

import com.damintsev.server.servlet.ServerConnectionImpl;
import com.google.gwt.core.client.GWT;

/**
 * Created by adamintsev
 * Date: 10.10.13 18:54
 */
public class Service {
    public static ServerConnectionAsync instance = GWT.create(ServerConnection.class);
}
