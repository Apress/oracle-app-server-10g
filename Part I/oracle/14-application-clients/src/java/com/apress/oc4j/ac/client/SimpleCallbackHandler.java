/*
 * Created on 31-May-2004
 */
package com.apress.oc4j.ac.client;

import java.io.IOException;
import java.util.Properties;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextInputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;


/**
 * Callback handler that does not actually do anything
 */
public class SimpleCallbackHandler implements CallbackHandler {

	private static final String USERNAME = "janm";
	private static final String PASSWORD = "H2134!hjsf8";
	
	private Properties securityProperties;
	
	/**
	 * .ctor
	 */
	public SimpleCallbackHandler() {
		securityProperties = new Properties();
		
		securityProperties.setProperty("Username", USERNAME);
		securityProperties.setProperty("Password", PASSWORD);
		securityProperties.setProperty("URL", "ormi://localhost/oracle");
	}
	
	/**
	 * Handle Name callback
	 * 
	 * @param callback The callback
	 */
	private void handleNameCallback(NameCallback callback) {
		callback.setName(securityProperties.getProperty(callback.getPrompt()));
	}
	
	/**
	 * Handle Password callback
	 * 
	 * @param callback The callback
	 */
	private void handlePasswordCallback(PasswordCallback callback) {
		callback.setPassword(securityProperties.getProperty(callback.getPrompt()).toCharArray());
	}
	
	/**
	 * Handle TextInput callback
	 * 
	 * @param callback The callback
	 */
	private void handleTextInputCallback(TextInputCallback callback) {
		callback.setText(securityProperties.getProperty(callback.getPrompt()));
	}
	
	/* (non-Javadoc)
	 * @see javax.security.auth.callback.CallbackHandler#handle(javax.security.auth.callback.Callback[])
	 */
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			Callback callback = callbacks[i];
			if (callback instanceof NameCallback) handleNameCallback((NameCallback)callback);
			else if (callback instanceof PasswordCallback) handlePasswordCallback((PasswordCallback)callback);
			else if (callback instanceof TextInputCallback) handleTextInputCallback((TextInputCallback)callback);
		}
	}
}
