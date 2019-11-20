package br.edu.unifil.servlet;

import java.lang.reflect.Field;
import java.util.ArrayList;

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
                    sb.append("<th scope=\"row\">");
                    sb.append(value);
                    sb.append("</th>");
                } else {
                    sb.append("<td>");
                    sb.append(value);
                    sb.append("</td>");
                }
            }
            sb.append("</tr>");
        });
        sb.append("</tbody>");
        sb.append("</table>");

        return sb.toString();
    }
}