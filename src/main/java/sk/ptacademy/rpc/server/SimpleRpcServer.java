/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.ptacademy.rpc.server;

import org.apache.xmlrpc.webserver.WebServer;

/**
 *
 * @author firecracker
 */
public class SimpleRpcServer extends WebServer {

    public SimpleRpcServer(int pPort) {
        super(pPort);
        initialize();
    }
    
    public void initialize(){
        XmlRpcHandlerRegistry xmlRpcHandlerRegistry = new SimpleXmlRpcHandleRegistry();
        xmlRpcHandlerRegistry.registerHandler("substraction", new SubstractionRpcHandler());
        xmlRpcHandlerRegistry.registerHandler("addition", new AdditionRpcHandler());
        xmlRpcHandlerRegistry.registerHandler("multiplication", new MultiplicationRpcHandler());
        this.getXmlRpcServer().setHandlerMapping(xmlRpcHandlerRegistry);
    }
    
}
