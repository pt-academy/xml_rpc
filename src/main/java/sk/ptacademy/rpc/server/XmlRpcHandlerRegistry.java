/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.ptacademy.rpc.server;

import org.apache.xmlrpc.XmlRpcHandler;
import org.apache.xmlrpc.server.XmlRpcHandlerMapping;

/**
 *
 * @author firecracker
 */
public interface XmlRpcHandlerRegistry extends XmlRpcHandlerMapping{
    public void registerHandler(String name, XmlRpcHandler handler);
}
