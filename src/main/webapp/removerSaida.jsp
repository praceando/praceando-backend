<%@ page import="org.common.SqlExitDML" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    SqlExitDML saida = (SqlExitDML) request.getAttribute("saida");
    String tabelaNome = request.getParameter("tabela");
%>
    <h1>Tentou remover ID:<%=request.getParameter("id")%> na tabela '<%=tabelaNome%>'</h1>

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

    <a class="botao-voltar" href="redirect?opcao=visualizar&tabela=<%=tabelaNome%>">Voltar</a>
</body>
</html>
