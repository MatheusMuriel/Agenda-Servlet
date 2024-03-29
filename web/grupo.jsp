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
    <title>Grupos</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <div class="row justify-content-md-center">
            <h1>Grupos</h1>
        </div>

        <form action="/grupo/listar" method="get">
            <button type="submit" class="btn btn-primary">Listar Grupos</button>
        </form>

        <a type="button" class="btn btn-primary" href="/vincular.jsp?entidade1=grupo&entidade2=contato"
        > Vincular Grupo com Contato</a>

        <form action="/grupo/novo" method="post">
            <label>Descrição</label>
            <input type="text" name="descricao" id="descricao">
            <button type="submit"  class="btn btn-primary">Criar</button>
        </form>

        <div class="row justify-content-md-center" style="padding-top: 30px;">
            <a type="button" class="btn btn-secondary" href="/index.jsp"
            > Voltar </a>
        </div>
    </div>
</body>
</html>
