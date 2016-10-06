/*
 * Created on 20-Jun-2004
 */
package com.apress.oc4j.connectors;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.ConnectionSpec;
import javax.resource.cci.RecordFactory;
import javax.resource.cci.ResourceAdapterMetaData;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ManagedConnectionFactory;

/**
 * @author janm
 */
public class SampleConnectionFactory implements ConnectionFactory {

	private SampleConnectionData connectionData = new SampleConnectionData();
	private SampleRecordFactory recordFactory = new SampleRecordFactory();
	private Reference reference;
	private ConnectionManager connectionManager = new SampleDefaultConnectionManager();
	private ManagedConnectionFactory managedConnectionFactory;

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionFactory#getConnection()
	 */
	public Connection getConnection() throws ResourceException {
		return getConnection(new SampleConnectionData());
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionFactory#getConnection(javax.resource.cci.ConnectionSpec)
	 */
	public Connection getConnection(ConnectionSpec connectionSpec) throws ResourceException {

		SampleConnectionData info;
		Connection ret;

		if (connectionSpec instanceof SampleConnectionData) {
			SampleConnectionData sd = (SampleConnectionData)connectionSpec;
			info = sd;
		} else {
			throw new ResourceException("ConnectionSpec object is of type " + connectionSpec.getClass().getName() + " not SampleConnectionData");
		}

		return (Connection)connectionManager.allocateConnection(managedConnectionFactory, info);
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionFactory#getRecordFactory()
	 */
	public RecordFactory getRecordFactory() throws ResourceException {
		return recordFactory;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ConnectionFactory#getMetaData()
	 */
	public ResourceAdapterMetaData getMetaData() throws ResourceException {
		return new SampleResourceAdapterMetadata();
	}

	/* (non-Javadoc)
	 * @see javax.resource.Referenceable#setReference(javax.naming.Reference)
	 */
	public void setReference(Reference reference) {
		this.reference = reference;
	}

	/* (non-Javadoc)
	 * @see javax.naming.Referenceable#getReference()
	 */
	public Reference getReference() throws NamingException {
		return reference;
	}

	/**
	 * @return Returns the connectionManager.
	 */
	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	/**
	 * @param connectionManager The connectionManager to set.
	 */
	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	/**
	 * @return Returns the managedConnectionFactory.
	 */
	public ManagedConnectionFactory getManagedConnectionFactory() {
		return managedConnectionFactory;
	}

	/**
	 * @param managedConnectionFactory The managedConnectionFactory to set.
	 */
	public void setManagedConnectionFactory(ManagedConnectionFactory managedConnectionFactory) {
		this.managedConnectionFactory = managedConnectionFactory;
	}
}