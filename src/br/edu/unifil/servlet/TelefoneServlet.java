package br.edu.unifil.servlet;

import br.edu.unifil.MVC.Controllers.TelefoneController;
import br.edu.unifil.MVC.Models.Telefone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TelefoneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println(Util.envelopaHead("Todos os Telefones"));

        out.println("<h1> " + "Lista de todos os Telefones" +"</h1>");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");

        EntityManager em = emf.createEntityManager();

        TelefoneController tC = new TelefoneController(em);
        ArrayList<Telefone> listaTelefones = tC.listarTodos();

        out.println(Util.gerarTable(listaTelefones, "Telefone"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String telefone = req.getParameter("telefone");

        Telefone t = new Telefone();
        t.setTelefone(telefone);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");

        EntityManager em = emf.createEntityManager();

        TelefoneController tC = new TelefoneController(em);
        tC.salvar(t);

        resp.sendRedirect("http://localhost:8080/telefone.jsp");
    }
}
