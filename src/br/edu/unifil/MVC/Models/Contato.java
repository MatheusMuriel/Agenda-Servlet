package br.edu.unifil.MVC.Models;

import javax.persistence.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.StringJoiner;

@Entity
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_contato;

    String primeiroNome;
    String ultimoNome;

    String email;

    /*@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "contatos_telefones",
            joinColumns = { @JoinColumn(name = "id_contato") },
            inverseJoinColumns = { @JoinColumn(name = "id_telefone") })
    Collection<Telefone> telefones;*/

    /*@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "contatos_gupos",
            joinColumns = { @JoinColumn(name = "id_contato") },
            inverseJoinColumns = { @JoinColumn(name = "id_grupo") })
    Collection<Grupo> grupos;*/

    public Contato(String primeiroNome, String ultimoNome, String email) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.email = email;
    }

    public Contato() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add(this.primeiroNome);
        sj.add(this.ultimoNome);
        sj.add(" :: ");
        sj.add(this.email);
        return sj.toString();
    }

    /**
     *  Metodo que compara se a intancia do contato coresponde a um determinado nome.
     *
     *  Verifica o nome e o sobrenome.
     *
     * @param nome Nome a ser comparado.
     * @return true se corresponde ou false se não corresponde.
     */
    public boolean comparaNome(String nome) {

        String n1 = normalizaNome(this.primeiroNome);
        String n2 = normalizaNome(this.ultimoNome);
        nome = normalizaNome(nome);

        // Se o nome do contato contem a string, ou se a string contem o nome de contato.
        if ( ( n1.contains(nome) || n2.contains(nome) ) || ( nome.contains(n1) || nome.contains(n2) ) )  {
            return true;
        } else {
            return false;
        }
    }

    public String normalizaNome(String s1) {
        s1 = Normalizer
                .normalize(s1, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .toLowerCase();

        return s1;
    }

    public ArrayList<Telefone> getTelefones() {
        //return telefones;
        return  null;
    }

    public ArrayList<Grupo> getGrupos() {
        //return grupos;
        return  null;
    }

    public void addReferenciaTelefone(Object ob) {
        //this.telefones.add( (Telefone) ob );
    }

    public int getId() {
        return id_contato;
    }

    public void setId(int id) {
        this.id_contato = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }
}
