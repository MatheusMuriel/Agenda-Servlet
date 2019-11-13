package br.edu.unifil.servlet;

import br.edu.unifil.Entidades.Contato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ContatoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String nome = req.getParameter("nome");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT c FROM Contato c");
        List r = q.getResultList();

        r.stream().forEach(o -> out.println("<h1> " + o +"</h1>"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");

        EntityManager em = emf.createEntityManager();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String nome = req.getParameter("nome");

        Contato c = new Contato();
        c.setPrimeiroNome(nome);

        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        out.println("<h1> " + nome +"</h1>");
    }
}
