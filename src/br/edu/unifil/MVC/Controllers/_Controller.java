package br.edu.unifil.MVC.Controllers;

import javax.persistence.EntityManager;
import java.util.ArrayList;

public interface _Controller<T> {
    EntityManager em = null;

    public void inicialize(EntityManager em);

    public void salvar(T o);

    public void remover(T o);

    public void alterar(T o);

    public T findById(int id);

    public ArrayList<T> listarTodos();

    public boolean existe(T o);
}
