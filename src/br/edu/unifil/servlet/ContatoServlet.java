package br.edu.unifil.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ContatoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");

        //EntityManager em = emf.createEntityManager();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String nome = req.getParameter("nome");

        out.println("<h1> " + nome +"</h1>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String nome = req.getParameter("nome");

        out.println("<h1> " + nome +"</h1>");
    }
}
