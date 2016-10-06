/* OK
 * Created on 20-Jun-2004
 */
package com.apress.oc4j.connectors;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;


/**
 * @author janm
 */
public class SampleConnectionManager implements ConnectionManager {

	/* (non-Javadoc)
	 * @see javax.resource.spi.ConnectionManager#allocateConnection(javax.resource.spi.ManagedConnectionFactory, javax.resource.spi.ConnectionRequestInfo)
	 */
	public Object allocateConnection(ManagedConnectionFactory managedConnectionFactory, ConnectionRequestInfo connectionRequestInfo) throws ResourceException {
        ManagedConnection connection;
        
        // should test here for matching connection data
        connection = (ManagedConnection)managedConnectionFactory.createManagedConnection(null, connectionRequestInfo);
        
        // get the client connection
        return (Connection)connection.getConnection(null, connectionRequestInfo);
	}

}
