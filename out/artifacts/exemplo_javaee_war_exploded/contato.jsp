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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <div class="row justify-content-md-center">
            <h1>Contatos</h1>
        </div>

        <form action="/contato/listar" method="get">
            <button type="submit" class="btn btn-primary">Listar Contatos</button>
        </form>

        <a type="button" class="btn btn-primary" href="/vincular.jsp?entidade1=contato&entidade2=telefone"
        > Vincular Contato com Telefone </a>

        <a type="button" class="btn btn-primary" href="/vincular.jsp?entidade1=contato&entidade2=grupo"
        > Vincular Contato com Grupo </a>

        <form action="/contato/novo" method="post">
            <label>Nome</label>
            <input type="text" name="nome" id="nome">

            <label>Sobrenome</label>
            <input type="text" name="sobreNome" id="sobreNome">

            <label>Email</label>
            <input type="text" name="email" id="Email">

            <button type="submit" class="btn btn-primary">Criar</button>
        </form>

    </div>
</body>
</html>
