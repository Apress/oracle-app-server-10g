/*
 * Created on 31-May-2004
 */
package com.apress.oc4j.ac.ejb;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


/**
 * @author janm
 */
public interface HelloWorldHome extends EJBHome {
	
	/**
	 * Creates the HelloWorld object
	 * 
	 * @return HelloWorld instance
	 * @throws CreateException
	 * @throws RemoteException
	 */
	public HelloWorld create() throws CreateException, RemoteException;
}
