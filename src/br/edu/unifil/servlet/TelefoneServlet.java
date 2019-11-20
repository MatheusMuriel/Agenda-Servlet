package br.edu.unifil.servlet;

import br.edu.unifil.MVC.Controllers.TelefoneController;

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

public class TelefoneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1> " + "Lista de todos os Telefones" +"</h1>");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");

        EntityManager em = emf.createEntityManager();

        TelefoneController tC = new TelefoneController(em);
        tC.listarTodos()
                .stream()
                .forEach(o -> out.println("<h2> " + o +"</h2>"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1> " + "TELEFONEEE" +"</h1>");

    }
}
