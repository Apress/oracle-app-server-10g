/*
 * Created on Apr 29, 2004
 */
package com.apress.oracle10g.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

/**
 * @author robh
 *  
 */
public class JaxServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            InputStream webXml = this.getServletContext().getResourceAsStream(
                    "/WEB-INF/web.xml");

            DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            
            Document doc = builder.parse(webXml);
            
            response.setContentType("text/html");
            
            response.getOutputStream().println(doc.getClass().getName());
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}