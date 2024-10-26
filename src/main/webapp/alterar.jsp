<%@ page import="org.common.html.HTMLInput" %>
<%@ page import="org.model.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulário de Inserção</title>
</head>
<body>
    <%
        String tabelaNome = request.getParameter("tabela");
        Model model = (Model) request.getAttribute("model");
    %>
    <h1>Formulário de atualização: <%=tabelaNome%></h1>
    <form method="post" action="alterar-done">
        <input type="hidden" name="tabelaNome" value="<%=tabelaNome%>">
        <%=HTMLInput.getForm(tabelaNome, model)%>
        <button type="submit">Alterar</button>
    </form>
</body>
</html>