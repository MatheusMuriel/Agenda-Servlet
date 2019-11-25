package br.edu.unifil.servlet;

import br.edu.unifil.MVC.Controllers.ContatoController;
import br.edu.unifil.MVC.Controllers.TelefoneController;
import br.edu.unifil.MVC.Models.Contato;
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

public class ContatoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println(Util.envelopaHead("Todos os Telefones"));

        out.println("<h1> " + "Lista de todos os Contatos" +"</h1>");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");

        EntityManager em = emf.createEntityManager();

        ContatoController cC = new ContatoController(em);
        ArrayList<Contato> listaContatos = cC.listarTodos();

        out.println(Util.gerarTable(listaContatos, "Nome", "Sobrenome", "Email"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");
        EntityManager em = emf.createEntityManager();
        ContatoController cC = new ContatoController(em);

        String id = req.getParameter("id");

        if (id != null) {
            id = id.replaceAll("\\/|\\s|&|-","");
        }

        if(id == null){
            String nome = req.getParameter("nome_criar");
            String sobreNome = req.getParameter("sobrenome_criar");
            String email = req.getParameter("email_criar");

            Contato c = new Contato();
            c.setPrimeiroNome(nome);
            c.setUltimoNome(sobreNome);
            c.setEmail(email);

            cC.salvar(c);
        } else {
            String nome = req.getParameter("nome_alterar");
            String sobreNome = req.getParameter("sobrenome_alterar");
            String email = req.getParameter("email_alterar");

            Contato c = cC.findById( Integer.parseInt(id) );
            c.setPrimeiroNome(nome);
            c.setUltimoNome(sobreNome);
            c.setEmail(email);

            cC.salvar(c);
        }

        resp.sendRedirect("http://localhost:8080/contato.jsp");
    }
}
