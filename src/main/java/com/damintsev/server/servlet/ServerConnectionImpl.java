package com.damintsev.server.servlet;

import com.damintsev.client.service.ServerConnection;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Damintsev Andrey
 * Date: 06.10.13
 * Time: 11:24
 */
@Service("ServerConnection")
public class ServerConnectionImpl implements ServerConnection {

    @Override
    public void test() {
        System.out.println("FUCK U!!!!!");
    }
}
