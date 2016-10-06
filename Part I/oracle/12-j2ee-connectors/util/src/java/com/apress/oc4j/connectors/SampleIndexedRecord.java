/* OK
 * Created on 20-Jun-2004
 */
package com.apress.oc4j.connectors;

import java.util.ArrayList;

import javax.resource.cci.IndexedRecord;


/**
 * @author janm
 */
public class SampleIndexedRecord extends ArrayList implements IndexedRecord {
	private String recordName = "recordName";
	private String recordShortDescription = "recordDescription";

	/* (non-Javadoc)
	 * @see javax.resource.cci.Record#getRecordName()
	 */
	public String getRecordName() {
		return recordName;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Record#setRecordName(java.lang.String)
	 */
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Record#setRecordShortDescription(java.lang.String)
	 */
	public void setRecordShortDescription(String recordShortDescription) {
		this.recordShortDescription = recordShortDescription;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Record#getRecordShortDescription()
	 */
	public String getRecordShortDescription() {
		return recordShortDescription;
	}

}
