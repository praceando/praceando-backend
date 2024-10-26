<%@ page import="org.common.html.HTMLInput" %>
<%@ page import="org.model.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String tabelaNome = request.getParameter("tabela");
        Model model = (Model) request.getAttribute("model");
    %>

    <title>Alterando ID <%=model.getId()%> da tabela <%=tabelaNome%></title>
</head>
<body>

    <h1>Formulário de atualização: <%=tabelaNome%></h1>
    <form method="post" action="alterar-done">
        <input type="hidden" name="tabelaNome" value="<%=tabelaNome%>">
        <%=HTMLInput.getForm(tabelaNome, model)%>
        <button type="submit">Alterar</button>
    </form>
</body>
</html>