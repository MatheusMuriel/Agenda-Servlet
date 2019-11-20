package br.edu.unifil.servlet;

import br.edu.unifil.MVC.Controllers.ContatoController;
import br.edu.unifil.MVC.Models.Contato;

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
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1> " + "Lista de todos os Contatos" +"</h1>");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");

        EntityManager em = emf.createEntityManager();

        ContatoController contatoController = new ContatoController(em);
        contatoController.listarTodos()
                .stream()
                .forEach(o -> out.println("<h2> " + o +"</h2>"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String sobreNome = req.getParameter("sobreNome");
        String email = req.getParameter("email");

        Contato c = new Contato();
        c.setPrimeiroNome(nome);
        c.setUltimoNome(sobreNome);
        c.setEmail(email);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");

        EntityManager em = emf.createEntityManager();

        ContatoController contatoController = new ContatoController(em);
        contatoController.salvar(c);

        resp.sendRedirect("http://localhost:8080/contato.jsp");
    }
}
