package br.edu.unifil.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1> " + name +"</h1>");

        if (name.equals("contatos")){
            resp.sendRedirect("http://localhost:8080/contato.jsp");
        }
        //resp.sendRedirect("http://localhost:8080/contato.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String destino = req.getParameter("destino");

        if (destino.equals("contatos")){
            resp.sendRedirect("http://localhost:8080/contato.jsp");
        }

        switch (destino){
            case "contato":
                resp.sendRedirect("http://localhost:8080/contato.jsp");
                break;
            case "telefone":
                resp.sendRedirect("http://localhost:8080/telefone.jsp");
                break;
            case "grupo":
                resp.sendRedirect("http://localhost:8080/grupo.jsp");
                break;
            default:
                out.println("<h1> " + "Pagina desconhecida :c" +"</h1>");
                break;
        }

    }
}
