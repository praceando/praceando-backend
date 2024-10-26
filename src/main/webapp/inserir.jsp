<%@ page import="org.common.html.HTMLInput" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulário de Inserção</title>
</head>
<body>
    <%
        String tabelaNome = request.getParameter("tabela");
    %>
    <h1>Formulário de inserção: <%=tabelaNome%></h1>
    <form method="post" action="inserir">
        <input type="hidden" name="tabelaNome" value="<%=tabelaNome%>">
        <%=HTMLInput.getForm(tabelaNome)%>
        <button type="submit">Inserir</button>
    </form>
</body>
</html>
