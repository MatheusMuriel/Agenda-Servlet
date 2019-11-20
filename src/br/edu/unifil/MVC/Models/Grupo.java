package br.edu.unifil.MVC.Models;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_grupo;

    String description;

    public Grupo(String descricao) {
    }

    public Grupo() {

    }

    @Override
    public String toString() {
        return this.description;
    }

    public int getId() {
        return id_grupo;
    }

    public void setId(int id) {
        this.id_grupo = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
