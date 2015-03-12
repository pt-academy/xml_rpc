/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.ptacademy.rpc.server;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcHandler;
import org.apache.xmlrpc.XmlRpcRequest;

/**
 *
 * @author firecracker
 */
class AdditionRpcHandler implements XmlRpcHandler {

    @Override
    public Object execute(XmlRpcRequest request) throws XmlRpcException {
        if(request.getParameterCount() != 2){
            return "Invalid number of params!";
        }
        Double param1 = Double.parseDouble(request.getParameter(0).toString());
        Double param2 = Double.parseDouble(request.getParameter(1).toString());
        return param1.doubleValue()+param2.doubleValue();
    }

 
    
}
