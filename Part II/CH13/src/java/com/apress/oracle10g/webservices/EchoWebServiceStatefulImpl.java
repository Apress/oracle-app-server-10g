/*
 * Created on May 4, 2004
 */
package com.apress.oracle10g.webservices;


/**
 * @author robh
 *
 */
public class EchoWebServiceStatefulImpl implements EchoWebService {

    private int count = 0;
    
    public String echo(String message) {
        return message + count++;
    }

}
