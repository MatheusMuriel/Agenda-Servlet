package br.edu.unifil.MVC.Controllers;

import br.edu.unifil.MVC.Models.Telefone;

import javax.persistence.EntityManager;
import java.util.ArrayList;

public class TelefoneController implements _Controller<Telefone> {
    EntityManager em;

    public TelefoneController(EntityManager em) {
        inicialize(em);
    }

    public void inicialize(EntityManager em) {
        this.em = em;
    }

    public void salvar(Telefone t) {
        try {
            this.em.getTransaction().begin();
            this.em.persist(t);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    public void remover(Telefone t) {
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

    public void alterar(Telefone o) {
        // TODO implementar
        try {

        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    public Telefone findById(int id) {
        return this.em.find(Telefone.class, id);
    }

    public ArrayList<Telefone> listarTodos() {
        // TODO implementar
        return null;
    }

    /**
     * Verifica se o telefone está salvo no banco.
     * @param t Telefone a se verificar.
     * @return True se estiver salvo, caso contraio False
     */
    public boolean existe(Telefone t) {
        return this.em.contains(t);
    }

    public ArrayList<Telefone> findByNumero(String num) {
        return null;
    }

    public ArrayList<Telefone> findByGrupo(String desc) {
        return null;
    }

    public ArrayList<Telefone> findByContato(String nome) {
        return null;
    }
}
