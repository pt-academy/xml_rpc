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
public class SubstractionRpcHandler implements XmlRpcHandler{   
    @Override
    public Object execute(XmlRpcRequest xmlRpcRequest) throws XmlRpcException {
        if(xmlRpcRequest.getParameterCount() != 2){
            return("Invalid number of parameters.");
        }
        
        Double operandA = Double.parseDouble(xmlRpcRequest.getParameter(0).toString());
        Double operandB = Double.parseDouble(xmlRpcRequest.getParameter(1).toString());
        return operandA.doubleValue() - operandB.doubleValue();
    }
    
}
