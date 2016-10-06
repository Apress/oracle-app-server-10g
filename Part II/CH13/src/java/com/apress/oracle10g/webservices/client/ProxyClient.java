 /*
 * Created on May 4, 2004
 */
package com.apress.oracle10g.webservices.client;

import com.apress.oracle10g.webservices.proxy.EchoWebServiceProxy;


/**
 * @author robh
 *
 */
public class ProxyClient {

    public static void main(String[] args) throws Exception {
        EchoWebServiceProxy proxy = new EchoWebServiceProxy();
        
        System.out.println("Using URL: " + proxy._getSoapURL());
       
        System.out.println(proxy.echo("Hello World"));
        System.out.println(proxy.echo("Hello World"));
        System.out.println(proxy.echo("Hello World"));
    }
}

