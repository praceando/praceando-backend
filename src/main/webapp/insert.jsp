<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String tabelaNome = (String) request.getAttribute("tabelaNome");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Executar Insert</title>
  <link rel="stylesheet" href="css/insert.css">
  <link rel="stylesheet" href="css/comum.css">
</head>
<body>
<div id="linhaEnfeite"></div>

<div id="fundoIrregular"></div>
<img src="assets/Icone.png" alt="Praceando">


<p class="sublinhar">Insert</p>

<form action="informacoesInsert" method="post">
<div id="caixaLogin">
  <p class="comando" id="comandoInsert">INSERT INTO</p>
  <p class="comando" id="tabelaInsert"><%= tabelaNome %></p>
  <p class="comando" id="comandoInsertpt2">VALUES</p>

  <input type="text" id="insert" name="Valoresinsert" class="inputForm" required/>

  <button type="submit">Executar</button>
</div>
</form>

<p id="textoEnfeite">&lt; \ &gt;</p>
</body>
</html>