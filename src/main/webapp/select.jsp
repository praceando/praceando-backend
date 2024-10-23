<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String tabelaNome = (String) request.getSession().getAttribute("tabelaNome");
  String[] colunas = (String[]) request.getAttribute("colunas");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Executar Delete</title>
  <link rel="stylesheet" href="css/comum.css">
</head>
<body>
<div id="linhaEnfeite"></div>

<div id="fundoIrregular"></div>
<img src="assets/Icone.png" alt="Praceando">


<p class="sublinhar">Select</p>

<form action="informacoesSelect" method="post">
  <div id="caixaLogin">
    <p class="comando" id="comandoSelect">SELECT</p>

    <%
      for (String coluna : colunas) {
        if (coluna != null) {

    %>
    <label>
      <span><%=coluna%></span>
      <input class="comando" type='checkbox' name='colunasEscolhidas' value=<%=coluna%>>
    </label>
    <br/>
    <%    }
      }
    %>

    <p class="comando" id="comandoSelectpt2">FROM <%= tabelaNome %></p>
e
    <input type="text" id="select" name="select" class="inputForm" required/>

    <button type="submit">Executar</button>
  </div>
</form>

<p id="textoEnfeite">&lt; \ &gt;</p>
</body>
</html>
