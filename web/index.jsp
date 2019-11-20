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
      out.println("Ola Mundo");
    %>
  </p>

  <form action="/a" method="get">
    <button type="submit" name="contatos">Contados</button>
  </form>
  </body>
</html>
