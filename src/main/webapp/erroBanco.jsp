<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Erro no Banco de Dados</title>
  <link rel="stylesheet" href="front_core/styles/crud/erroNoBanco.css">
</head>
<body>
  <%
    String tipoErro = (String) request.getAttribute("tipoErro");
    String mensagemErro = (String) request.getAttribute("mensagemErro");
  %>
  <div id="linhaEnfeite"></div>
  <img src="assets/logo/logo.png" alt="Blomera">
  <p class="sublinhar"><%=tipoErro%></p>
  <p id="descricao"><%=mensagemErro%></p>
</body>
</html>