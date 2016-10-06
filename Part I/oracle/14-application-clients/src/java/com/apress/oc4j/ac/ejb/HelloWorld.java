/*
 * Created on 31-May-2004
 */
package com.apress.oc4j.ac.ejb;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


/**
 * @author janm
 */
public interface HelloWorld extends EJBObject {
	/**
	 * Returns the appropriate greeting
	 * 
	 * @return The greeting
	 * @throws RemoteException
	 */
	public String getGreeting() throws RemoteException;
}
