<%@ page import="java.util.ArrayList" %>
<%@ page import="br.edu.unifil.servlet.VinculadorServlet" %>
<%@ page import="br.edu.unifil.servlet.Util" %><%--
  Created by IntelliJ IDEA.
  User: usu_dsv_1
  Date: 21/11/2019
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vinculo</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <div class="row justify-content-md-center">
    <%
        String entidade1 = request.getParameter("entidade1");
        String entidade2 = request.getParameter("entidade2");

        out.println("<h1> Vinculando ");
        switch (entidade1){
            case "contato":
                out.println("Contato");
                break;
            case "telefone":
                out.println("Telefone");
                break;
            case "grupo":
                out.println("Grupo");
                break;
        }

        out.println(" com ");

        switch (entidade2){
            case "contato":
                out.println("Contato");
                break;
            case "telefone":
                out.println("Telefone");
                break;
            case "grupo":
                out.println("Grupo");
                break;
        }
        out.println("</h1>");
    %>
        </div>
        <form action="/vincular" name="frmVincular" method="post">
            <div class="row justify-content-center">
                <div class="col-3">
                    <div class="row justify-content-center">
                        <select class="form-control" name="id_1">
                            <%
                                ArrayList<String[]> lista1 = Util.listarEntidade(entidade1);
                                for (String[] o : lista1){
                                    out.println("<option value=\"");
                                    out.println(o[0]);
                                    out.println("\">");
                                    out.println(o[1]);
                                    out.println("</option>");
                                }
                            %>
                        </select>
                    </div>
                </div>
                <div class="col-3">
                    <div class="row justify-content-center">
                        <select class="form-control" name="id_2">
                            <%
                                ArrayList<String[]> lista2 = Util.listarEntidade(entidade2);
                                for (String[] o : lista2){
                                    out.println("<option value=\"");
                                    out.println(o[0]);
                                    out.println("\">");
                                    out.println(o[1]);
                                    out.println("</option>");
                                }
                            %>
                        </select>
                    </div>
                </div>
            </div>

            <div class="row justify-content-center">
                <input type="hidden" name="entidade1" value=<%=entidade1%> />
                <input type="hidden" name="entidade2" value=<%=entidade2%>/>
                    <input type="button" class="btn btn-primary" name="" value="Vincular"
                           onclick="{document.frmVincular.submit();}"
                    />
            </div>
        </form>

        <div class="row justify-content-md-center" style="padding-top: 30px;">
            <a type="button" class="btn btn-secondary" href="/index.jsp"
            > Voltar </a>
        </div>

    </div>
</body>
</html>
