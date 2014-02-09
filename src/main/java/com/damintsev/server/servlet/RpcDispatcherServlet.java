package com.damintsev.server.servlet;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.gwt.user.server.rpc.impl.ServerSerializationStreamReader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author Damintsev Andrey
 *         09.02.14.
 */

/**
 * Overriden GWT Dispacher class to integrate with String beans
 */
public class RpcDispatcherServlet extends RemoteServiceServlet {

    /*
 * (non-Javadoc)
 *
 * @see
 * com.google.gwt.user.server.rpc.RemoteServiceServlet#processCall(java.
 * lang.String)
 */
    @Override
    public String processCall(String payload) throws SerializationException {
        try {
            String serviceIntfName = getInterfaceClassName(payload);
            RPCRequest rpcRequest = RPC.decodeRequest(payload, null, this);
            onAfterRequestDeserialized(rpcRequest);
            Object service = getService(serviceIntfName);

            return RPC.invokeAndEncodeResponse(service,
                    rpcRequest.getMethod(),
                    rpcRequest.getParameters(),
                    rpcRequest.getSerializationPolicy());
        } catch (IncompatibleRemoteServiceException ex) {
            log("An IncompatibleRemoteServiceException was thrown while processing this call.", ex);
            return RPC.encodeResponseForFailure(null, ex);
        }
    }

    /**
     * Reads the payload looking for the interface class name.
     *
     * @param payload
     * @return
     * @throws SerializationException
     */
    private String getInterfaceClassName(String payload)
            throws SerializationException {
        ServerSerializationStreamReader streamReader = new ServerSerializationStreamReader(
                Thread.currentThread().getContextClassLoader(), this);
        streamReader.prepareToRead(payload);
        return streamReader.readString();
    }

    /**
     * getService will look in context for bean with name of interface. It also
     * verifies the bean implements the given interface.
     *
     * @return
     * @throws org.springframework.beans.BeansException
     * @throws ClassNotFoundException
     */
    protected Object getService(String itfName) throws BeansException {
        try {
            return BeanFactoryUtils.beanOfTypeIncludingAncestors(
                    WebApplicationContextUtils.getWebApplicationContext(getServletContext()),
                    Class.forName(itfName));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
