/* OK
 * Created on 20-Jun-2004
 */
package com.apress.oc4j.connectors;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.Interaction;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;
import javax.resource.cci.ResourceWarning;


/**
 * @author janm
 */
public class SampleInteraction implements Interaction {
	
	private SampleConnection connection;
	private ResourceWarning warning = null;

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#close()
	 */
	public void close() throws ResourceException {
		// noop
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#getConnection()
	 */
	public Connection getConnection() {
		return connection;
	}
	
	/**
	 * Sets sample connection
	 * 
	 * @param connection The connection
	 */
	public void setConnection(SampleConnection connection) {
		this.connection = connection;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#execute(javax.resource.cci.InteractionSpec, javax.resource.cci.Record, javax.resource.cci.Record)
	 */
	public boolean execute(InteractionSpec interactionSpec, Record in, Record out) throws ResourceException {
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#execute(javax.resource.cci.InteractionSpec, javax.resource.cci.Record)
	 */
	public Record execute(InteractionSpec interactionSpec, Record record) throws ResourceException {
		SampleIndexedRecord result = new SampleIndexedRecord();
		SampleInteractionSpec spec = (SampleInteractionSpec)interactionSpec;
		String function = spec.getFunctionName();
		long timeout = spec.getExecutionTimeout();
		
		// perform something here.
		return result;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#getWarnings()
	 */
	public ResourceWarning getWarnings() throws ResourceException {
		return warning;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#clearWarnings()
	 */
	public void clearWarnings() throws ResourceException {
		warning = null;
	}

}
