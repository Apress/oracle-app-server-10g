/*
 * Created on 20-Jun-2004
 */
package com.apress.oc4j.connectors;

import javax.resource.cci.ResourceAdapterMetaData;


/**
 * @author janm
 */
public class SampleResourceAdapterMetadata implements ResourceAdapterMetaData {

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterVersion()
	 */
	public String getAdapterVersion() {
		return "1.0";
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterVendorName()
	 */
	public String getAdapterVendorName() {
		return "Apress";
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterName()
	 */
	public String getAdapterName() {
		return "Sample adapter";
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getAdapterShortDescription()
	 */
	public String getAdapterShortDescription() {
		return "Adapter short description";
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getSpecVersion()
	 */
	public String getSpecVersion() {
		return "1.0";
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#getInteractionSpecsSupported()
	 */
	public String[] getInteractionSpecsSupported() {
		return new String[] { };
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#supportsExecuteWithInputAndOutputRecord()
	 */
	public boolean supportsExecuteWithInputAndOutputRecord() {
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#supportsExecuteWithInputRecordOnly()
	 */
	public boolean supportsExecuteWithInputRecordOnly() {
		return true;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.ResourceAdapterMetaData#supportsLocalTransactionDemarcation()
	 */
	public boolean supportsLocalTransactionDemarcation() {
		return false;
	}

}
