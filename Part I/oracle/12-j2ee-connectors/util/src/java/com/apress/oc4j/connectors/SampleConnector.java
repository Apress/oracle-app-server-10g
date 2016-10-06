/*
 * Created on 06-Jun-2004
 */
package com.apress.oc4j.connectors;


/**
 * Simple class to demonstrate classloading settings in orion-web.xml
 * 
 * @author janm
 */
public class SampleConnector {
	
	/**
	 * Method that gets version of the class. It is just intended to demonstrate the classloading
	 * mechanism.
	 * 
	 * @return The version string
	 */
	public String getVersion() {
		return "v2";
	}
}
