<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Saída de Inserção</title>
</head>
<body>
  <%
    String tabelaNome = request.getParameter("tabelaNome");
      Map<String, String> params = (Map<String, String>) request.getAttribute("params");
  %>

  <h1>Tentou inserir na tabela <%=tabelaNome%></h1>
  <h2>Com parâmetros:</h2>
  <table class="params">
      <tr>
          <td>Nome</td>
          <td>Valor</td>
      </tr>
      <%for (Map.Entry<String, String> linha : params.entrySet()) {
      %>
        <td>
            <%=linha.getKey()%>
            <%=linha.getValue()%>
        </td>
      <%
        }
      %>
  </table>
  <br><br>
</body>
</html>
