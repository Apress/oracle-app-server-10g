/*
 * Created on 20-Jun-2004
 */
package com.apress.oc4j.connectors;

import java.io.PrintWriter;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.security.auth.Subject;


/**
 * @author janm
 */
public class SampleManagedConnectionFactory implements ManagedConnectionFactory {
	private PrintWriter logWriter;

	/* (non-Javadoc)
	 * @see javax.resource.spi.ManagedConnectionFactory#createConnectionFactory(javax.resource.spi.ConnectionManager)
	 */
	public Object createConnectionFactory(ConnectionManager connectionManager) throws ResourceException {
		return new SampleConnectionFactory();
	}

	/* (non-Javadoc)
	 * @see javax.resource.spi.ManagedConnectionFactory#createConnectionFactory()
	 */
	public Object createConnectionFactory() throws ResourceException {
		return new SampleConnectionFactory();
	}

	/* (non-Javadoc)
	 * @see javax.resource.spi.ManagedConnectionFactory#createManagedConnection(javax.security.auth.Subject, javax.resource.spi.ConnectionRequestInfo)
	 */
	public ManagedConnection createManagedConnection(Subject subject, ConnectionRequestInfo connectionRequestInfo) throws ResourceException {
		return new SampleConnectionFactory().getManagedConnectionFactory().createManagedConnection(subject, connectionRequestInfo);
	}

	/* (non-Javadoc)
	 * @see javax.resource.spi.ManagedConnectionFactory#matchManagedConnections(java.util.Set, javax.security.auth.Subject, javax.resource.spi.ConnectionRequestInfo)
	 */
	public ManagedConnection matchManagedConnections(Set connections, Subject subject, ConnectionRequestInfo connectionRequestInfo) throws ResourceException {
		return new SampleConnectionFactory().getManagedConnectionFactory().createManagedConnection(subject, connectionRequestInfo);
	}

	/* (non-Javadoc)
	 * @see javax.resource.spi.ManagedConnectionFactory#setLogWriter(java.io.PrintWriter)
	 */
	public void setLogWriter(PrintWriter logWriter) throws ResourceException {
		this.logWriter = logWriter;
	}

	/* (non-Javadoc)
	 * @see javax.resource.spi.ManagedConnectionFactory#getLogWriter()
	 */
	public PrintWriter getLogWriter() throws ResourceException {
		return logWriter;
	}

}
