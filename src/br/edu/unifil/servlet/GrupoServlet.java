package br.edu.unifil.servlet;

import br.edu.unifil.MVC.Controllers.GrupoController;
import br.edu.unifil.MVC.Models.Grupo;

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

public class GrupoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<head>");
        out.println(variaveisGlobais.HEAD_BOOTSTRAP);
        out.println("</head>");

        out.println("<h1> " + "Lista de todos os Grupos" +"</h1>");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");

        EntityManager em = emf.createEntityManager();

        GrupoController gC = new GrupoController(em);
        ArrayList<Grupo> listaGrupos = gC.listarTodos();

        StringBuilder sb = new StringBuilder();
        sb.append("<table class=\"table\">");
        sb.append("<thead><tr>");
        sb.append("<th scope=\"col\">#</th><th scope=\"col\">Descrição</th>");
        sb.append("</tr></thead>");
        sb.append("<tbody>");

        listaGrupos.forEach(grupo -> {
            sb.append("<tr>");
            sb.append("<th scope=\"row\">");
            sb.append(grupo.getId());
            sb.append("</th>");
            sb.append("<td>");
            sb.append(grupo.getDescription());
            sb.append("</td>");
            sb.append("</tr>");
        });
        sb.append("</tbody>");
        sb.append("</table>");

        out.println(sb.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String descricao = req.getParameter("descricao");

        Grupo g = new Grupo();
        g.setDescription(descricao);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");

        EntityManager em = emf.createEntityManager();

        GrupoController gC = new GrupoController(em);
        gC.salvar(g);

        resp.sendRedirect("http://localhost:8080/grupo.jsp");
    }
}
