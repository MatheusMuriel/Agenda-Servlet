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
    <title>Agendinha marota</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </head>
  <body>

  <div class="container">
    <div class="row justify-content-md-center">
      <h1>Bem vindo a Agenda Servlet :D</h1>
    </div>

    <form name="frmRedirect" method="post" action="/a">
      <input type="hidden" name="destino" />
      <div class="row justify-content-center">
        <div class="col-2">
          <div class="row justify-content-center">
            <input type="button" class="btn btn-primary" name="contato" value="Contatos"
                   onclick="{document.frmRedirect.destino.value=this.name;document.frmRedirect.submit();}"
            />
          </div>
        </div>
        <div class="col-2">
          <div class="row justify-content-center">
            <input type="button" class="btn btn-primary" name="grupo" value="Grupos"
                   onclick="{document.frmRedirect.destino.value=this.name;document.frmRedirect.submit();}"
            />
          </div>
        </div>
        <div class="col-2">
          <div class="row justify-content-center">
            <input type="button" class="btn btn-primary" name="telefone" value="Telefones"
                   onclick="{document.frmRedirect.destino.value=this.name;document.frmRedirect.submit();}"
            />
          </div>
        </div>
      </div>
    </form>
  </div>
  </body>
</html>
