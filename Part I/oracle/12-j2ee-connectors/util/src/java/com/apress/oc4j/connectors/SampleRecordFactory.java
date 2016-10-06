/* OK
 * Created on 20-Jun-2004
 */
package com.apress.oc4j.connectors;

import javax.resource.ResourceException;
import javax.resource.cci.IndexedRecord;
import javax.resource.cci.MappedRecord;
import javax.resource.cci.RecordFactory;


/**
 * @author janm
 */
public class SampleRecordFactory implements RecordFactory {

	/* (non-Javadoc)
	 * @see javax.resource.cci.RecordFactory#createMappedRecord(java.lang.String)
	 */
	public MappedRecord createMappedRecord(String name) throws ResourceException {
		return new SampleMappedRecord();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.RecordFactory#createIndexedRecord(java.lang.String)
	 */
	public IndexedRecord createIndexedRecord(String name) throws ResourceException {
		return new SampleIndexedRecord();
	}

}
