<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String tabelaNome = (String) request.getSession().getAttribute("tabelaNome"); %>

  <!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Escolha a Ação</title>
  <link rel="stylesheet" href="css/comum.css">
  <link rel="stylesheet" href="css/comum2.css">
  <link rel="stylesheet" href="css/escolherAcao.css">
</head>
<body>
<div id="linhaEnfeite"></div>

<div id="fundoIrregular"></div>
<img src="assets/Icone.png" alt="Praceando">


<p id="titulo">Selecione a operação que você deseja executar:</p>

<form action="escolher-acao" method="post">
  <div id="caixaLogin">
    <div class="container-checkbox">

      <%
          if (tabelaNome.equals("Frase Sustentável") || tabelaNome.equals("Tag")) {
      %>
          <label><input type="radio" name="opcao" class="checkbox-arredondado" value="Delete"> Delete</label>\n"
      <%
          }
      %>

      <label><input type="radio" name="opcao" class="checkbox-arredondado" value="Insert"> Insert</label>
      <label><input type="radio" name="opcao" class="checkbox-arredondado" value="Select"> Select</label>
      <label><input type="radio" name="opcao" class="checkbox-arredondado" value="Update"> Update</label>
      <button type="submit">Confirmar</button>
    </div>
  </div>
</form>


<p id="lembreteVolta">Tabela: <%=tabelaNome%>></p>
<p id="lembreteVoltaAviso">Deseja trocar?</p>
<a href="escolherTabela.jsp" id="voltar">&lt;</a>

<p id="textoEnfeite">&lt; \ &gt;</p>
</body>
</html>