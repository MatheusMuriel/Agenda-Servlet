package br.edu.unifil.MVC.Controllers;

import br.edu.unifil.MVC.Models.Grupo;

import javax.persistence.EntityManager;
import java.util.ArrayList;

public class GrupoController implements _Controller<Grupo> {
    EntityManager em;

    public GrupoController(EntityManager em) {
        inicialize(em);
    }

    public void inicialize(EntityManager em) {
        this.em = em;
    }

    public void salvar(Grupo g) {
        try {
            this.em.getTransaction().begin();
            this.em.persist(g);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    public void remover(Grupo o) {
        // TODO implementar
        try {
            this.em.getTransaction().begin();
            //this.em.
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    public void alterar(Grupo o) {
        // TODO implementar
        try {

        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    public Grupo findById(int id) {
        return this.em.find(Grupo.class, id);
    }

    public ArrayList<Grupo> listarTodos() {
        // TODO implementar
        return null;
    }

    public boolean existe(Grupo g) {
        return this.em.contains(g);
    }

    public ArrayList<Grupo> findByNumero(String numeroConsulta) {
        return null;
    }

    public ArrayList<Grupo> findByNome(String nome) {
        return null;
    }

    public ArrayList<Grupo> findByDescricao(String desc) {
        return null;
    }

    public ArrayList<Grupo> findByContato(String nome) {
        return null;
    }
}
