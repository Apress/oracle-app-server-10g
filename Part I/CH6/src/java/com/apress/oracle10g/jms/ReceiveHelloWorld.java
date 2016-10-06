/*
 * Created on Apr 19, 2004
 */
package com.apress.oracle10g.jms;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;


/**
 * @author robh
 *
 */
public class ReceiveHelloWorld extends AbstractJMSClient{

    public static void main(String[] args) throws Exception {
        ReceiveHelloWorld recevier = new ReceiveHelloWorld();
        recevier.receive();
    }
    
    public void receive() throws NamingException, JMSException {
        // get queue and connection
        Queue q = getQueue();
        QueueConnection connection = getQueueConnection();

        // start...
        connection.start();
        QueueSession session = connection.createQueueSession(false,
                Session.AUTO_ACKNOWLEDGE);
        
        // receive
        QueueReceiver receiver = session.createReceiver(q);
        TextMessage msg = (TextMessage)receiver.receiveNoWait();
        
        if(msg != null)
            System.out.println("Received: " + msg.getText());
        else
            System.out.println("No message received");
        
        // close
        receiver.close();
        session.close();
        connection.close();
    }
}
