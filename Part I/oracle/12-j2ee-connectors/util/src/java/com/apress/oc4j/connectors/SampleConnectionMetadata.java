/* OK
 * Created on 20-Jun-2004
 */
package com.apress.oc4j.connectors;

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionMetaData;


/**
 * @author janm
 */
public class SampleConnectionMetadata implements ConnectionMetaData {

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionMetaData#getEISProductName()
	 */
	public String getEISProductName() throws ResourceException {
		return "Sample EIS Name";
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionMetaData#getEISProductVersion()
	 */
	public String getEISProductVersion() throws ResourceException {
		return "1.0";
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionMetaData#getUserName()
	 */
	public String getUserName() throws ResourceException {
		return "foobar";
	}

}
