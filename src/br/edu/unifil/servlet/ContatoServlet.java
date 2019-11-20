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
import java.util.ArrayList;

public class ContatoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println(Util.envelopaHead("Todos os Telefones"));

        out.println("<h1> " + "Lista de todos os Contatos" +"</h1>");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");

        EntityManager em = emf.createEntityManager();

        ContatoController contatoController = new ContatoController(em);
        ArrayList<Contato> listaContatos = contatoController.listarTodos();

        out.println(Util.gerarTable(listaContatos, "Nome", "Sobrenome", "Email"));


        /*StringBuilder sb = new StringBuilder();
        sb.append("<table class=\"table\">");
        sb.append("<thead><tr>");
        sb.append("<th scope=\"col\">#</th><th scope=\"col\">Nome</th><th scope=\"col\">Sobrenome</th><th scope=\"col\">Email</th>");
        sb.append("</tr></thead>");
        sb.append("<tbody>");

        listaContatos.forEach(contato -> {
            sb.append("<tr>");
            sb.append("<th scope=\"row\">");
            sb.append(contato.getId());
            sb.append("</th>");
            sb.append("<td>");
            sb.append(contato.getPrimeiroNome());
            sb.append("</td>");
            sb.append("<td>");
            sb.append(contato.getUltimoNome());
            sb.append("</td>");
            sb.append("<td>");
            sb.append(contato.getEmail());
            sb.append("</td>");
            sb.append("</tr>");
        });
        sb.append("</tbody>");
        sb.append("</table>");

        out.println(sb.toString());*/
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
