/* OK
 * Created on 20-Jun-2004
 */
package com.apress.oc4j.connectors;

import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.ResultSetInfo;


/**
 * @author janm
 */
public class SampleConnection implements Connection, LocalTransaction {
	
	/* (non-Javadoc)
	 * @see javax.resource.cci.Connection#createInteraction()
	 */
	public Interaction createInteraction() throws ResourceException {
		SampleInteraction interaction = new SampleInteraction();
		interaction.setConnection(this);
		return interaction;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Connection#getLocalTransaction()
	 */
	public LocalTransaction getLocalTransaction() throws ResourceException {
		return this;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Connection#getMetaData()
	 */
	public ConnectionMetaData getMetaData() throws ResourceException {
		return new SampleConnectionMetadata();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Connection#getResultSetInfo()
	 */
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		throw new NotSupportedException("Result Set support not implemented");
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Connection#close()
	 */
	public void close() throws ResourceException {
		// noop
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.LocalTransaction#begin()
	 */
	public void begin() throws ResourceException {
		// noop
		
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.LocalTransaction#commit()
	 */
	public void commit() throws ResourceException {
		// noop
		
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.LocalTransaction#rollback()
	 */
	public void rollback() throws ResourceException {
		// noop
		
	}
}
