package br.edu.unifil.servlet;

import br.edu.unifil.MVC.Controllers.ContatoController;
import br.edu.unifil.MVC.Controllers.GrupoController;
import br.edu.unifil.MVC.Controllers.TelefoneController;
import br.edu.unifil.MVC.Models.Contato;
import br.edu.unifil.MVC.Models.Grupo;
import br.edu.unifil.MVC.Models.Telefone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VinculadorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entidade1 = req.getParameter("entidade1");
        int id1 = Integer.parseInt(req.getParameter("id_1").replaceAll("(\\s|\\n|\\t|\\\")", ""));
        String entidade2 = req.getParameter("entidade2");
        int id2 = Integer.parseInt(req.getParameter("id_2").replaceAll("(\\s|\\n|\\t|\\\")", ""));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");
        EntityManager em = emf.createEntityManager();

        ContatoController cC = new ContatoController(em);
        TelefoneController tC = new TelefoneController(em);
        GrupoController gC = new GrupoController(em);

        Contato c;
        Telefone t;
        Grupo g;

        switch (entidade1){
            case "contato":
                c = cC.findById(id1);
                switch (entidade2){
                    case "telefone":
                        t = tC.findById(id2);
                        c.vinculaTelefone(t);
                        break;
                    case "grupo":
                        g = gC.findById(id2);
                        c.vinculaGrupo(g);
                        break;
                }
                break;
            case "telefone":
                t = tC.findById(id1);
                if (entidade2.equals("contato")){
                    c = cC.findById(id2);
                    c.vinculaTelefone(t);
                } else {
                    System.err.println("Tentativa de vinculo invalida: " + entidade1 + " <-> " + entidade2);
                }
            case "grupo":
                g = gC.findById(id1);
                if (entidade2.equals("contato")){
                    c = cC.findById(id2);
                    c.vinculaGrupo(g);
                } else {
                    System.err.println("Tentativa de vinculo invalida: " + entidade1 + " <-> " + entidade2);
                }
                break;
        }
        resp.sendRedirect("http://localhost:8080/");
    }
}
