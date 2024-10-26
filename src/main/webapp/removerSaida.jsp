<%@ page import="org.common.SqlExitDML" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    SqlExitDML saida = (SqlExitDML) request.getAttribute("saida");
%>
    <h1>Tentou remover ID:<%=request.getParameter("id")%> na tabela '<%=request.getParameter("tabela")%>'</h1>

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

</body>
</html>
