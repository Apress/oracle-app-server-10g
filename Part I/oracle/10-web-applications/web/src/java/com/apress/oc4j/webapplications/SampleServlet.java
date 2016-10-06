/*
 * Created on 05-Jun-2004
 */
package com.apress.oc4j.webapplications;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * OC4J - Chapter 10 - Web Applications
 * 
 * This class represents a simple servlet that handles GET and POST methods and 
 * simply prints out Hello, World to the response stream.
 * 
 * @author janm
 */
public class SampleServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer count = (Integer)request.getSession().getAttribute("count");
		if (count == null) count = new Integer(0);
		request.getSession().setAttribute("count", new Integer(count.intValue() + 1));
		
		Object publisher = getServletContext().getInitParameter("publisher");
		ClassloaderTester tester = new ClassloaderTester();
		
		if (request.getParameter("plain") != null) {
			response.setContentType("text/plain");
		}
		response.getOutputStream().print("Foobar, " + count + ", published by " + publisher + ", version " + tester.getVersion());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}