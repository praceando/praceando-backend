<%@ page import="org.common.html.HTMLInput" %>
<%@ page import="org.model.Model" %>
<%@ page import="org.common.Tabela" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        Tabela tabela = (Tabela) request.getAttribute("tabela");
        String tabelaInterface = tabela.getNomeInterface();
        String tabelaBanco = tabela.getNomeBanco();

        Model model = (Model) request.getAttribute("model");
    %>

    <title>Alterando ID <%=model.getId()%> da tabela <%=tabelaInterface%></title>
</head>
<body>

    <h1>Formulário de atualização: <%=tabelaInterface%></h1>
    <form method="post" action="alterar-done">
        <input type="hidden" name="tabelaNome" value="<%=tabelaBanco%>">
        <%=HTMLInput.getForm(tabelaBanco, model)%>
        <button type="submit">Alterar</button>
    </form>
</body>
</html>