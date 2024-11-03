<%@ page import="java.util.Map" %>
<%@ page import="org.common.SqlExitDML" %>
<%@ page import="org.common.Tabela" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Saída de Inserção</title>
</head>
<body>
  <%
      Tabela tabela = (Tabela) request.getAttribute("tabela");
      String tabelaInterface = tabela.getNomeInterface();
      String tabelaBanco = tabela.getNomeBanco();

      Map<String, String> params = (Map<String, String>) request.getAttribute("params");
      SqlExitDML saida = (SqlExitDML) request.getAttribute("saida");
  %>

  <h1>Tentou inserir na tabela de <%=tabelaInterface%></h1>
  <h2>Com parâmetros:</h2>
  <table class="params">
      <tr>
          <td>Nome</td>
          <td>Valor</td>
      </tr>
      <%for (Map.Entry<String, String> linha : params.entrySet()) {
      %>
        <tr>
            <td>
                <%=linha.getKey()%>
            </td>
            <td>
                <%=linha.getValue()%>
            </td>
        </tr>
      <%
        }
      %>
  </table>

  <div class="saida">
      <h2>Saída:</h2>
      <p><%=saida.toString()%></p>

      <%if (saida.hasErro()) {
      %>
      <br>
      <p><%=saida.getErro()%></p>
      <%}
      %>
  </div>

  <a class="botao-voltar" href="visualizar?tabela=<%=tabelaBanco%>">Voltar</a>
  <br><br>
</body>
</html>
