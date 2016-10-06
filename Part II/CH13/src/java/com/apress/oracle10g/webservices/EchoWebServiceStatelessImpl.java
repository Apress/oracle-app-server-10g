/*
 * Created on May 4, 2004
 */
package com.apress.oracle10g.webservices;


/**
 * @author robh
 *
 */
public class EchoWebServiceStatelessImpl implements EchoWebService {

    public String echo(String message) {
        return message;
    }

}
