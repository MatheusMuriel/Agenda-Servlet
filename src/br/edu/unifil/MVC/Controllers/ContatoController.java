package br.edu.unifil.MVC.Controllers;

import br.edu.unifil.MVC.Models.Contato;

import javax.persistence.EntityManager;
import java.util.ArrayList;

public class ContatoController implements _Controller<Contato> {
    EntityManager em;

    public ContatoController(EntityManager em) {
        inicialize(em);
    }

    public void inicialize(EntityManager em) {
        this.em = em;
    }

    public void salvar(Contato c) {
        try {
            this.em.getTransaction().begin();
            this.em.persist(c);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    public void remover(Contato o) {
        try {
            this.em.getTransaction().begin();
            this.em.remove(o);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    public void alterar(Contato o) {
        // TODO implementar
        try {

        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    public Contato findById(int id) {
        return this.em.find(Contato.class, id);
    }

    public ArrayList<Contato> listarTodos() {
        // TODO implementar
        return null;
    }

    public boolean existe(Contato c) {
        return this.em.contains(c);
    }

    public ArrayList<Contato> findByNumero(String numeroConsulta) {
        return null;
    }

    public ArrayList<Contato> findByGrupo(String desc) {
        return null;
    }

    public ArrayList<Contato> findByNome(String nome) {
        return null;
    }
}
