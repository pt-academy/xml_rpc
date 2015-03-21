/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.ptacademy.rpc.server;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

        
/**
 *
 * @author firecracker
 */
public class SimpleRpcServerTest {    
    private static final int SERVER_PORT = 1380;
    private static final String SERVER_URL = "http://localhost:"+SERVER_PORT+"/RPC2";
    private static final XmlRpcClient xmlRpcClient = new XmlRpcClient();
    private static final XmlRpcClientConfigImpl xmlRpcClientConfig = new XmlRpcClientConfigImpl();
    private static final SimpleRpcServer server = new SimpleRpcServer(SERVER_PORT);


    @BeforeClass
    public static void setup() throws MalformedURLException, IOException{
        xmlRpcClientConfig.setServerURL(new URL(SERVER_URL));
        xmlRpcClient.setConfig(xmlRpcClientConfig);
        server.start();
    }
   
    @Test
    public void testSubstraction() throws XmlRpcException{
        List params = new ArrayList();
        params.add(new Integer(17));
        params.add(new Integer(13));
        
        Object result= xmlRpcClient.execute("substraction",params);
        
        if (result instanceof Double){
            assertEquals(4, ((Double) result).intValue());
        }
    }
    
    @Test
    public void testMultiplication() throws XmlRpcException{
        List params = new ArrayList();
        params.add(new Integer(17));
        params.add(new Integer(10));
        
        Object result = xmlRpcClient.execute("multiplication",params);
        
        if (result instanceof Double){
            assertEquals(170, ((Double) result).intValue());
        }
    }
    
    
    /*
    @Test
    public void serverConnectionTest() throws IOException{
        SimpleRpcServer server = new SimpleRpcServer(SERVER_PORT);
        server.start();
        
       final URLConnection connection = new URL(SERVER_URL).openConnection();
       connection.connect();
    }
    */
    
    @Test
    public void additionTest() throws XmlRpcException {
        List params = new ArrayList();
        params.add(new Integer(17));
        params.add(new Integer(13));
        
        Object result= xmlRpcClient.execute("addition",params);
        
        if (result instanceof Double){
            assertEquals(30, ((Double) result).intValue());
        }
    }
    
    @AfterClass
    public static void shutdown() {
        server.shutdown();
    }
    
}
