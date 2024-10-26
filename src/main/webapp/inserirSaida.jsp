<%@ page import="java.util.Map" %>
<%@ page import="org.common.SqlExitDML" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Saída de Inserção</title>
</head>
<body>
  <%
    String tabelaNome = request.getParameter("tabelaNome");
    Map<String, String> params = (Map<String, String>) request.getAttribute("params");
    SqlExitDML saida = (SqlExitDML) request.getAttribute("saida");
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

  <h2>Saída:</h2>
  <div class="saida">
      <p><%=saida.toString()%></p>

      <%if (saida.hasErro()) {
      %>
      <br>
      <p><%=saida.getErro()%></p>
      <%}
      %>

  </div>
  <br><br>
</body>
</html>
