package br.edu.unifil.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Set response content type
        resp.setContentType("text/html");
//        resp.addHeader("header-teste","teste123");

        // Actual logic goes here.
        PrintWriter out = resp.getWriter();
        out.println("<h1> Hello, world!</h1>");
    }
}
