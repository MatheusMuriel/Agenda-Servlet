package br.edu.unifil.MVC.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_telefone;

    String telefone;

    @ManyToMany(mappedBy = "telefones")
    Set<Contato> contatos = new HashSet<>();

    public Telefone(String telefone) {
    }

    public Telefone() {

    }

    @Override
    public String toString() {
        return this.telefone;
    }

    public int getId() {
        return id_telefone;
    }

    public void setId(int id) {
        this.id_telefone = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
