/*
 * Created on Apr 19, 2004
 */
package com.apress.oracle10g.jms;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author robh
 *  
 */
public abstract class AbstractJMSClient {

    private static final String FACTORY_NAME = "java:comp/env/jms/queueConnectionFactory";

    private static final String QUEUE_NAME = "java:comp/env/jms/helloWorldQueue";

    private QueueConnectionFactory factory = null;

    protected Queue getQueue() throws NamingException {

        Context ctx = new InitialContext();

        //get the connection factory
        QueueConnectionFactory factory = getQueueConnectionFactory();

        // get the queue
        Queue q = (Queue) ctx.lookup(QUEUE_NAME);

        return q;
    }

    protected QueueConnection getQueueConnection() throws NamingException,
            JMSException {
        return getQueueConnectionFactory().createQueueConnection();
    }

    private QueueConnectionFactory getQueueConnectionFactory()
            throws NamingException {
        Context ctx = new InitialContext();
        factory = (QueueConnectionFactory) ctx.lookup(FACTORY_NAME);
        return factory;
    }
}