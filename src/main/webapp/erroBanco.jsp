<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erro no Banco de Dados</title>
    <link rel="stylesheet" href="front_core/styles/crud/comum.css">
    <link rel="stylesheet" href="front_core/styles/crud/erroNoBanco.css">
    </head>
  <body>
  <%
    // Pegando dados que saíram do Servlet

    String tipoErro = (String) request.getAttribute("tipoErro"); // Tipo do erro
    String mensagemErro = (String) request.getAttribute("mensagemErro"); // Mensagem do erro
  %>

    <div id="linhaEnfeite"></div>

    <div id="fundoIrregular"></div>
    <img src="assets/logo/Icone.png" alt="Praceando">

    <p id="titulo">Erro no Banco de Dados:</p>
    <p class="sublinhar"><%=tipoErro%></p>

    <div id="caixaLogin">
      <p id="descricao"><%=mensagemErro%></p>
    </div>

    <p id="textoEnfeite">&lt; \ &gt;</p>
  </body>
</html>