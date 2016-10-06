/*
 * Created on May 4, 2004
 */
package com.apress.oracle10g.webservices.client;


import javax.xml.namespace.QName;
import javax.xml.rpc.Call;

import org.apache.axis.client.Service;


/**
 * @author robh
 *
 */
public class SimpleJavaClient {

    private static final String SERVICE_URL = "http://localhost:8888/ws/echoStateful";
    
    public static void main(String[] args) throws Exception {
        
        // create the axis service
        Service service = new Service();
        Call call = service.createCall();
        
        call.setTargetEndpointAddress(SERVICE_URL);
        call.setOperationName(new QName("echo"));
        call.setProperty(Call.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
        
        Object[] params = new Object[] {"Hello World"};
        
        System.out.println(call.invoke(params));
        System.out.println(call.invoke(params));
        System.out.println(call.invoke(params));
    }
}
