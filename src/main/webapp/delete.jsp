<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String tabelaNome = (String) request.getSession().getAttribute("tabelaNome");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Executar Delete</title>
  <link rel="stylesheet" href="css/delete.css">
  <link rel="stylesheet" href="css/comum.css">
</head>
<body>
<div id="linhaEnfeite"></div>

<div id="fundoIrregular"></div>
<img src="assets/Icone.png" alt="Praceando">


<p class="sublinhar">Delete</p>

<form action="informacoesDelete" method="post">
  <div id="caixaLogin">
    <p class="comando" id="comandoDelete">DELETE FROM</p>
    <p class="comando" id="tabelaDelete"><%= tabelaNome %></p>
    <p class="comando" id="comandoDeletept2">WHERE ID_XXX =</p>

    <input type="text" id="delete" name="idDelete" class="inputForm" required/>

    <button type="submit">Executar</button>
  </div>
</form>

<p id="textoEnfeite">&lt; \ &gt;</p>
</body>
</html>
