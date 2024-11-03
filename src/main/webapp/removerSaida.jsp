<%@ page import="org.common.SqlExitDML" %>
<%@ page import="org.common.Tabela" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Tabela tabela = (Tabela) request.getAttribute("tabela");
    String tabelaInterface = tabela.getNomeInterface();
    String tabelaBanco = tabela.getNomeBanco();

    SqlExitDML saida = (SqlExitDML) request.getAttribute("saida");
%>
    <h1>Tentou remover ID:<%=request.getParameter("id")%> na tabela '<%=tabelaInterface%>'</h1>

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

    <a class="botao-voltar" href="visualizar?tabela=<%=tabelaBanco%>">Voltar</a>
</body>
</html>
