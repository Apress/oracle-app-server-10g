/*
 * Created on Apr 28, 2004
 */
package com.apress.oracle10g.javamail;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author robh
 *
 */
public class JavaMailServlet extends HttpServlet {

    private static final String LOCAL_NAME = "java:comp/env/mail/SampleMail";
    private static final String SUBJECT_NAME = "java:comp/env/defaultSubject";
    private static final String GLOBAL_NAME = "mail/SampleMail";
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get the parameters
        String jndiScope = request.getParameter("jndiScope");
        String subject = request.getParameter("subject");
        String to = request.getParameter("to");
        String from = request.getParameter("from");
        String body = request.getParameter("body");
        
        // get the mail session
        Session session = null;
        if("local".equals(jndiScope)) {
            session = getLocalMailSession();
        } else {
            session = getGlobalMailSession();
        }

        // create the mail
        try {
            Message mail = new MimeMessage(session);
        
            if((subject != null) && (subject.length() > 0)) {
                mail.setSubject(subject);
            } else {
                mail.setSubject(getDefaultSubject());
            }
            
            mail.setText(body);
            
            if((from != null) && (from.length() > 0)) {
                mail.setFrom(new InternetAddress(from));
            }
            
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
            // send
            Transport.send(mail);
        
        } catch(MessagingException e) {
            throw new ServletException("An error occured creating or sending the message", e);
        }
        
        // success!
        RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
        rd.forward(request, response);
    }
    
    private Session getGlobalMailSession() throws ServletException {
        try {
            Context ctx = new InitialContext();
            Session session = (Session)ctx.lookup(GLOBAL_NAME);
            
            log("Obtained mail session from global context");
            
            return session;
        } catch(NamingException ex) {
            throw new ServletException("Unable to locate mail session", ex);
        }
    }
    
    private Session getLocalMailSession() throws ServletException {
        try {
            Context ctx = new InitialContext();
            Session session = (Session)ctx.lookup(LOCAL_NAME);
            
            log("Obtained mail session from local context");
            
            return session;
        } catch(NamingException ex) {
            throw new ServletException("Unable to locate mail session", ex);
        }
    }
    
    private String getDefaultSubject() throws ServletException {
        try {
            Context ctx = new InitialContext();
            String subject = (String)ctx.lookup(SUBJECT_NAME);
            
            log("Obtained default subject " + subject + " from local context");
            
            return subject;
        } catch(NamingException ex) {
            throw new ServletException("Unable to locate mail session", ex);
        }
    }
}
