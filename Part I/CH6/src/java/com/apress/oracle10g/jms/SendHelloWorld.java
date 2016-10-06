/*
 * Created on Apr 19, 2004
 */
package com.apress.oracle10g.jms;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;

/**
 * @author robh
 *  
 */
public class SendHelloWorld extends AbstractJMSClient {

    public static void main(String[] args) throws Exception {
        SendHelloWorld sender = new SendHelloWorld();
        sender.send();
    }

    public void send() throws JMSException, NamingException {
        // get queue and connection
        Queue q = getQueue();
        QueueConnection connection = getQueueConnection();

        // start...
        connection.start();
        QueueSession session = connection.createQueueSession(false,
                Session.AUTO_ACKNOWLEDGE);

        // send
        QueueSender sender = session.createSender(q);
        TextMessage msg = session.createTextMessage();
        msg.setText("Hello World!");
        sender.send(msg);

        // close
        sender.close();
        session.close();
        connection.close();
        
        System.out.println("Message Sent");
    }
}