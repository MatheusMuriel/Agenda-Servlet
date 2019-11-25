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
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Set;

public class Util {
    public static String HEAD_BOOTSTRAP = "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>";

    public static String envelopaHead(String titulo){
        StringBuilder sb = new StringBuilder();

        sb.append("<head>");
        sb.append(Util.HEAD_BOOTSTRAP);

        sb.append("<title>");
        sb.append(titulo);
        sb.append("</title>");

        sb.append("</head>");

        return sb.toString();
    }

    public static String gerarTable(ArrayList<?> items, String... titlesHeadTable){
        StringBuilder sb = new StringBuilder();

        sb.append("<table class=\"table\">");
        sb.append("<thead><tr>");
        sb.append("<th scope=\"col\">#</th>");

        for (String titleAux : titlesHeadTable ){
            sb.append("<th scope=\"col\">");
            sb.append(titleAux);
            sb.append("</th>");
        }

        sb.append("</tr></thead>");
        sb.append("<tbody>");

        items.forEach(o -> {
            sb.append("<tr>");
            Class<?> clazz = o.getClass();
            int id = -1;
            for(Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String nameF = field.getName();
                Object value = "??";
                try {
                    value = field.get(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (nameF.contains("id")){
                    id = (int) value;
                    sb.append("<th scope=\"row\">");
                    sb.append(value);
                    sb.append("</th>");
                } else if(field.getType() != Set.class) {
                    sb.append("<td>");
                    sb.append(value);
                    sb.append("</td>");
                }
            }
            sb.append("<td>");
            sb.append("<a type=\"button\" class=\"btn btn-primary\" href=");
            sb.append("\"/");
            sb.append(clazz.getSimpleName().toLowerCase());
            sb.append(".jsp?");

            sb.append("acao=");
            sb.append(acoesEntidade.alterar);
            sb.append("&");
            sb.append("id=");
            sb.append(id);

            sb.append("\">");

            sb.append("Alterar");
            sb.append("</a>");
            sb.append("</td>");

            sb.append("</tr>");
        });
        sb.append("</tbody>");
        sb.append("</table>");

        return sb.toString();
    }

    public static ArrayList<String[]> listarEntidade(String entidade){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");

        EntityManager em = emf.createEntityManager();

        switch (entidade){
            case "contato":
                ContatoController cC = new ContatoController(em);
                ArrayList<Contato> result_contato = cC.listarTodos();

                ArrayList<String[]> listaRetorno_contato = new ArrayList<>();

                result_contato.forEach(contato -> {
                       String[] valores = new String[2];
                       valores[0] = String.valueOf(contato.getId());
                       valores[1] = contato.getNomeCompleto();
                       listaRetorno_contato.add(valores);
                    });
                return listaRetorno_contato;
            case "telefone":
                TelefoneController tC = new TelefoneController(em);
                ArrayList<Telefone> result_telefone = tC.listarTodos();

                ArrayList<String[]> listaRetorno_telefone = new ArrayList<>();

                result_telefone.forEach(telefone -> {
                    String[] valores = new String[2];
                    valores[0] = String.valueOf(telefone.getId());
                    valores[1] = telefone.getTelefone();
                    listaRetorno_telefone.add(valores);
                });
                return listaRetorno_telefone;
            case "grupo":
                GrupoController gC = new GrupoController(em);
                ArrayList<Grupo> result_grupo = gC.listarTodos();

                ArrayList<String[]> listaRetorno_grupo = new ArrayList<>();

                result_grupo.forEach(grupo -> {
                    String[] valores = new String[2];
                    valores[0] = String.valueOf(grupo.getId());
                    valores[1] = grupo.getDescription();
                    listaRetorno_grupo.add(valores);
                });
                return listaRetorno_grupo;
        }
        return null;
    }

    public static ContatoController getContatoController() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");
        EntityManager em = emf.createEntityManager();

        return new ContatoController(em);
    }

    public static TelefoneController getTelefoneController(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");
        EntityManager em = emf.createEntityManager();

        return new TelefoneController(em);
    }

    public static GrupoController getGrupoController(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab3-jsp");
        EntityManager em = emf.createEntityManager();

        return new GrupoController(em);
    }

    public enum acoesEntidade{
        alterar, excluir, criar
    }
}
