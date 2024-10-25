<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erro no Banco de Dados</title>
    <link rel="stylesheet" href="css/comum.css">
    <link rel="stylesheet" href="css/erroNoBanco.css">
    </head>
  <body>
  <%
    String tipoErro = (String) request.getAttribute("tipoErro");
    String mensagemErro = (String) request.getAttribute("mensagemErro");
  %>
    <div id="linhaEnfeite"></div>

    <div id="fundoIrregular"></div>
    <img src="assets/Icone.png" alt="Praceando">

    <p id="titulo">Erro no Banco de Dados:</p>
    <p class="sublinhar"><%=tipoErro%></p>

    <div id="caixaLogin">
      <p id="descricao"><%=mensagemErro%></p>
    </div>

    <img src="assets/ErroDbIcone.jpg" alt="Erro do Db" id="erroBanco">


    <p id="textoEnfeite">&lt; \ &gt;</p>
  </body>
</html>