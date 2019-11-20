<%--
  Created by IntelliJ IDEA.
  User: usu_dsv_1
  Date: 20/11/2019
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Telefones</title>
</head>
<body>
    <h1>Telefones</h1>

    <form action="/telefone/listar" method="get">
        <button type="submit">Listar Telefones</button>
    </form>

    <form action="/telefone/novo" method="post">
        <label>Nome</label>
        <input type="text" name="nome" id="nome">
        <button type="submit">Enviar</button>
    </form>
</body>
</html>
