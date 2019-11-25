<%@ page import="br.edu.unifil.servlet.Util" %>
<%@ page import="br.edu.unifil.MVC.Controllers.ContatoController" %>
<%@ page import="br.edu.unifil.MVC.Models.Contato" %><%--
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
    <%
        String parametro1 = request.getParameter("acao");
        String parametro2 = request.getParameter("id");

        Util.acoesEntidade acao = null;
        int id = 0;
        if (parametro1 != null && parametro2 != null){
            acao = Util.acoesEntidade.valueOf(parametro1);
            id = Integer.parseInt(parametro2);
        }
    %>
    <div class="container">

        <%if(acao == Util.acoesEntidade.alterar){%>

        <div class="row justify-content-md-center">
            <h1>Alterando Contatado</h1>
        </div>

        <%
            ContatoController cC = Util.getContatoController();
            Contato c = cC.findById(id);
        %>

        <form action="/contato/alterar" method="post">
            <input type="hidden" name="id" value=<%=c.getId()%>/>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="nome_alterar">Nome</label>
                    <input type="text" class="form-control" name="nome_alterar" id="nome_alterar" placeholder="Nome" value=<%=c.getPrimeiroNome()%>>
                </div>
                <div class="form-group col-md-6">
                    <label for="sobrenome_alterar">Sobrenome</label>
                    <input type="text" class="form-control" name="sobrenome_alterar" id="sobrenome_alterar" placeholder="Sobrenome" value=<%=c.getUltimoNome()%>>
                </div>
            </div>
            <div class="form-group">
                <label for="email_alterar">Email</label>
                <input type="email" class="form-control" name="email_alterar" id="email_alterar" placeholder="Email" value=<%=c.getEmail()%>>
            </div>

            <button type="submit" class="btn btn-primary">Salvar</button>
            <a class="btn btn-danger" href="/contato.jsp">Cancelar</a>
        </form>

        <%} else if(acao == Util.acoesEntidade.criar) {%>
        <div class="row justify-content-md-center">
            <h1>Novo Contatado</h1>
        </div>

        <form action="/contato/novo" method="post">

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="nome_alterar">Nome</label>
                    <input type="text" class="form-control" name="nome_criar" id="nome_criar" placeholder="Nome">
                </div>
                <div class="form-group col-md-6">
                    <label for="sobrenome_alterar">Sobrenome</label>
                    <input type="text" class="form-control" name="sobrenome_criar" id="sobrenome_criar" placeholder="Sobrenome">
                </div>
            </div>
            <div class="form-group">
                <label for="email_alterar">Email</label>
                <input type="email" class="form-control" name="email_criar" id="email_criar" placeholder="Email">
            </div>

            <button type="submit" class="btn btn-primary">Salvar</button>
            <a class="btn btn-danger" href="/contato.jsp">Cancelar</a>
        </form>

        <%} else if(acao == Util.acoesEntidade.excluir) {%>
            <h5>Deletado**</h5>
        <%} else {%>
            <div class="row justify-content-md-center">
                <h1>Contatos</h1>
            </div>

            <div class="row justify-content-md-center" style="padding-top: 20px;">
                <form action="/contato/listar" method="get">
                    <button type="submit" class="btn btn-primary">Listar Contatos</button>
                </form>
            </div>

            <div class="row justify-content-md-center" style="padding-top: 10px;">
                <%String urlCriar = "/contato.jsp?acao=" + Util.acoesEntidade.criar + "&id=-1";%>
                <a type="button" class="btn btn-primary" href=<%=urlCriar%>
                > Criar novo Contato </a>
            </div>

            <div class="row justify-content-md-center" style="padding-top: 10px;">
                <a type="button" class="btn btn-primary" href="/vincular.jsp?entidade1=contato&entidade2=telefone"
                > Vincular Contato com Telefone </a>
            </div>

            <div class="row justify-content-md-center" style="padding-top: 10px;">
                <a type="button" class="btn btn-primary" href="/vincular.jsp?entidade1=contato&entidade2=grupo"
                > Vincular Contato com Grupo </a>
            </div>

            <div class="row justify-content-md-center" style="padding-top: 30px;">
                <a type="button" class="btn btn-secondary" href="/index.jsp"
                > Voltar </a>
            </div>
        <%}%>
    </div>
</body>
</html>
