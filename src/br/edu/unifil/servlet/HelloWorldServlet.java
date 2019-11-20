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
        String name = req.getParameter("name");

        if (name.equals("contatos")){
            resp.sendRedirect("http://localhost:8080/contato.jsp");
        }
        //resp.sendRedirect("http://localhost:8080/contato.jsp");
    }
}
