/*
 * Created on Apr 21, 2004
 */
package com.apress.oracle10g.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author robh
 *  
 */
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        ServletOutputStream output = response.getOutputStream();
        output.println("<html>");
        output.println("<head><title>HelloServlet</title></head>");

        output.println("<body>");

        output.println("<h1>Hello World!</h1>");

        output.println(request.getRemoteUser() + "<br>");
        output.println("In sr_users role? " + request.isUserInRole("sr_users")
                + "<br>");
        output.println("In sr_admins role? "
                + request.isUserInRole("sr_admins") + "<br>");

        output.println("</body>");

        output.println("</html>");
    }
}