package br.edu.unifil.MVC.Models;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo que compara se um produto é igual a este.
     * @param p2 Produto a ser comparado.
     * @return True se for igual, senão False
     */
    public boolean comparable(Product p2) {
        Product p1 = this;
        return ((p1.id == p2.id) && (p1.description.equals(p2.description)) && (p1.name.equals(p2.name)));
    }
}
