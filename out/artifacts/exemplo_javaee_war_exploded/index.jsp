<%--
  Created by IntelliJ IDEA.
  User: mhadaniya
  Date: 29/10/19
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Exemplo Java EE</title>
  </head>
  <body>
  <h1>Olá</h1>
  <p>
    <%
      out.println("Bem vindo a Agenda Servlet :D");
    %>
  </p>

  <form name="frmRedirect" method="post" action="/a">
    <input type="hidden" name="destino" />
    <input type="button" name="contato" value="Contatos" onclick="{document.frmRedirect.destino.value=this.name;document.frmRedirect.submit();}" />
    <input type="button" name="grupo" value="Grupos" onclick="{document.frmRedirect.destino.value=this.name;document.frmRedirect.submit();}" />
    <input type="button" name="telefone" value="Telefones" onclick="{document.frmRedirect.destino.value=this.name;document.frmRedirect.submit();}" />
  </form>

  </body>
</html>
