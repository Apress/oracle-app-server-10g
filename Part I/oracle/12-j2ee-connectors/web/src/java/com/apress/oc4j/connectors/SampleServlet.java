/*
 * Created on 05-Jun-2004
 */
package com.apress.oc4j.connectors;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * OC4J - Chapter 12 - J2EE Connector
 * 
 * This class represents a simple servlet that handles GET and POST methods.
 * 
 * @author janm
 */
public class SampleServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getOutputStream().print("Begin\r\n");
		String name;
		
		name = request.getParameter("name");
		if (name == null) { 
			name = "java:comp/env/eis/Sample";
		}
		response.getOutputStream().print("name = " + name + "\r\n\r\n");
		try {
			Context ctx = new InitialContext();
			ConnectionFactory connectionFactory = (ConnectionFactory)ctx.lookup(name);
			SampleConnectionData spec = new SampleConnectionData();
			spec.setUsername("scott");
			spec.setPassword("tiger");
			Connection c = connectionFactory.getConnection(spec);
		} catch (Exception ex) {
			response.getOutputStream().print(ex.getMessage());
		}
		
		response.getOutputStream().print("\r\nEnd.");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}