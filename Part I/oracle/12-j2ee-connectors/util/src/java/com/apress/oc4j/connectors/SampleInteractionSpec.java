/* OK
 * Created on 20-Jun-2004
 */
package com.apress.oc4j.connectors;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.resource.cci.InteractionSpec;

/**
 * @author janm
 */
public class SampleInteractionSpec implements InteractionSpec {

	private static final String PROP_FUNCTION_NAME_PROPERTY = "FunctionName";
	private static final String PROP_VERB_PROPERTY = "Verb";
	private static final String PROP_EXECUTION_TIMEOUT_PROPERTY = "ExecutionTimeout";

	/**
	 * The function name for this interaction.
	 */
	protected String functionName;

	/**
	 * The nature of this interaction.
	 * Must be one of SYNC_SEND, SYNC_SEND_RECEIVE or SYNC_RECEIVE.
	 */
	protected int verb;

	/**
	 * The timeout value for this interaction.
	 * If zero, there is no timeout.
	 */
	protected long executionTimeout;

	/** Utility field used by bound properties. */
	protected PropertyChangeSupport propertyChangeSupport;

	/** Creates a new instance of EmailInteractionSpec */
	public SampleInteractionSpec() {
		functionName = "noop";
		verb = SYNC_SEND_RECEIVE;
		executionTimeout = 0L;
		propertyChangeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * Getter for property functionName.
	 * @return Value of property functionName.
	 */
	public String getFunctionName() {
		return (functionName);
	}

	/** 
	 * Setter for property functionName.
	 * The allowed values of this property are set by the underlying EIS.
	 * @param function Fucntion name for this interaction.
	 * @exception IllegalArgumentException If the function name is null.
	 */
	public void setFunctionName(String function) throws IllegalArgumentException {
		if (null == function) throw new IllegalArgumentException("function name cannot be null");
		String oldValue = functionName;
		functionName = function;
		propertyChangeSupport.firePropertyChange(PROP_FUNCTION_NAME_PROPERTY, oldValue, functionName);
	}

	/**
	 * Getter for property verb.
	 * @return Value of property verb.
	 */
	public int getVerb() {
		return (verb);
	}

	/**
	 * Setter for property verb.
	 * @param verb New value of property verb.
	 */
	public void setVerb(int verb) {
		switch (verb) {
			case SYNC_SEND:
			case SYNC_SEND_RECEIVE:
			case SYNC_RECEIVE:
				break;
			default:
				throw new IllegalArgumentException("verb must be one of SYNC_SEND, SYNC_SEND_RECEIVE or SYNC_RECEIVE");
		}
		int oldValue = verb;
		this.verb = verb;
		propertyChangeSupport.firePropertyChange(PROP_VERB_PROPERTY, oldValue, verb);
	}

	/**
	 * Getter for property executionTimeout.
	 * @return Value of property executionTimeout.
	 */
	public long getExecutionTimeout() {
		return (executionTimeout);
	}

	/**
	 * Setter for property executionTimeout.
	 * @param timeout New value of property executionTimeout.
	 */
	public void setExecutionTimeout(long timeout) {
		if (0 > timeout) throw new IllegalArgumentException("timeout cannot be negative");
		long oldValue = executionTimeout;
		executionTimeout = timeout;
		propertyChangeSupport.firePropertyChange(PROP_EXECUTION_TIMEOUT_PROPERTY, new Long(oldValue), new Long(timeout));
	}

	/** Adds a PropertyChangeListener to the listener list.
	 * @param listener The listener to add.
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	/** Removes a PropertyChangeListener from the listener list.
	 * @param listener The listener to remove.
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}
}