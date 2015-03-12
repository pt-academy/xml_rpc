/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.ptacademy.rpc.server;

import java.util.HashMap;
import java.util.Map;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcHandler;
import org.apache.xmlrpc.server.XmlRpcNoSuchHandlerException;

/**
 *
 * @author firecracker
 */
public class SimpleXmlRpcHandleRegistry implements XmlRpcHandlerRegistry{
    private final Map<String, XmlRpcHandler> handlerRegistry = new HashMap();

    @Override
    public XmlRpcHandler getHandler(String handlerName) throws XmlRpcNoSuchHandlerException, XmlRpcException {
        return handlerRegistry.get(handlerName);
    }
    
    @Override
    public void registerHandler(String handlerName, XmlRpcHandler handler) {
        handlerRegistry.put(handlerName, handler);
    }    
}
