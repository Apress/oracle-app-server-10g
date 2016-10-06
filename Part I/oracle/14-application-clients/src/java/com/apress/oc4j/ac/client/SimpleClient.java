/*
 * Created on 31-May-2004
 */
package com.apress.oc4j.ac.client;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.login.LoginException;

import com.apress.oc4j.ac.ejb.HelloWorld;
import com.apress.oc4j.ac.ejb.HelloWorldHome;

/**
 * J2SE Application client
 * 
 * @author janm
 */
public class SimpleClient {

	
	/**
	 * .ctor
	 */
	private SimpleClient() {

	}

	/**
	 * Main example code
	 * 
	 * @throws NamingException
	 * @throws RemoteException
	 * @throws CreateException
	 * @throws LoginException
	 */
	private void run() throws NamingException, RemoteException, CreateException, LoginException {
		 Context ctx = new InitialContext();
		 HelloWorldHome home = (HelloWorldHome) ctx.lookup("java:comp/env/ejb/HelloWorldEJB");
		 HelloWorld bean = home.create();
		 // call the EJB method
		 System.out.println(bean.getGreeting());
	}

	/**
	 * Main entry point
	 * 
	 * @param args Command-line arguments
	 * @throws Exception We simply could not care less
	 */
	public static void main(String[] args) throws Exception {
		new SimpleClient().run();
	}

}