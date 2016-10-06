/*
 * Created on 31-May-2004
 */
package com.apress.oc4j.ac.ejb;

import javax.ejb.EJBLocalObject;


/**
 * @author janm
 */
public interface HelloWorldLocal extends EJBLocalObject {

	/**
	 * Returns appropriate greeting
	 * 
	 * @return The greeting
	 */
	public String getGreeting();
	
}
