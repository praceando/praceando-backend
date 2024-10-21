<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String tabelaNome = (String) request.getSession().getAttribute("tabelaNome");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Executar Update</title>
  <link rel="stylesheet" href="css/update.css">
  <link rel="stylesheet" href="css/comum.css">
</head>
<body>
<div id="linhaEnfeite"></div>

<div id="fundoIrregular"></div>
<img src="assets/Icone.png" alt="Praceando">


<p class="sublinhar">Update</p>

<form action="informacoesUpdate" method="post">
  <div id="caixaLogin">
    <p class="comando" id="comandoUpdate">UPDATE <%= tabelaNome %></p>
    <p class="comando" id="tabelaUpdate">SET</p>

    <input type="text" id="update1" name="valorAtualizadoUpdate" class="inputForm" required/>

    <p class="comando" id="comandoUpdatept2">WHERE ID_XXX =</p>

    <input type="text" id="update2" name="idUpdate" class="inputForm" required/>

    <button type="submit">Executar</button>
  </div>
</form>

<p id="textoEnfeite">&lt; \ &gt;</p>
</body>
</html>
