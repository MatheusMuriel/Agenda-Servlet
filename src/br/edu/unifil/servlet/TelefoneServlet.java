package br.edu.unifil.servlet;

import br.edu.unifil.MVC.Controllers.TelefoneController;
import br.edu.unifil.MVC.Models.Telefone;

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
import java.util.ArrayList;
import java.util.List;

public class TelefoneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<head>");
        out.println(variaveisGlobais.HEAD_BOOTSTRAP);
        out.println("</head>");


        out.println("<h1> " + "Lista de todos os Telefones" +"</h1>");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");

        EntityManager em = emf.createEntityManager();

        TelefoneController tC = new TelefoneController(em);
        ArrayList<Telefone> listaTelefones = tC.listarTodos();

        StringBuilder sb = new StringBuilder();
        sb.append("<table class=\"table\">");
        sb.append("<thead><tr>");
        sb.append("<th scope=\"col\">#</th><th scope=\"col\">Telefone</th>");
        sb.append("</tr></thead>");
        sb.append("<tbody>");

        listaTelefones.forEach(telefone -> {
            sb.append("<tr>");
            sb.append("<th scope=\"row\">");
            sb.append(telefone.getId());
            sb.append("</th>");
            sb.append("<td>");
            sb.append(telefone.getTelefone());
            sb.append("</td>");
            sb.append("</tr>");
        });
        sb.append("</tbody>");
        sb.append("</table>");

        out.println(sb.toString());

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
