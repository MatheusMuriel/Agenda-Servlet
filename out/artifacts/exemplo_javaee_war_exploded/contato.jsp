<%--
  Created by IntelliJ IDEA.
  User: mhadaniya
  Date: 05/11/19
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contatos</title>
</head>
<body>
    <h1>Contatos</h1>

    <form action="/contato/listar" method="get">
        <button type="submit">Listar Contatos</button>
    </form>

    <form action="/contato/novo" method="post">
        <label>Nome</label>
        <input type="text" name="nome" id="nome">
        <button type="submit">Enviar</button>
    </form>
</body>
</html>
