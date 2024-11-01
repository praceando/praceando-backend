<%@ page import="org.common.html.HTMLInput" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulário de Inserção</title>
    <link rel="stylesheet" href="./css/inserir.css">
</head>
<body cz-shortcut-listen="true">
    <div id="linhaEnfeite"></div>
    <%
        String tabelaBanco = request.getParameter("tabela");
        String tabelaInterface = (String) request.getAttribute("tabelaNome");
    %>
    <p>Formulário de inserção: <span id="gradiente"><%=tabelaInterface%></span></p>
    <div id="centralizar">
        <div id="caixaInsert">
            <form method="post" action="inserir-done">
                <input type="hidden" name="tabelaNome" value="<%=tabelaBanco%>">
                <%=HTMLInput.getForm(tabelaBanco)%>
                <button type="submit" id="botaoInserir">Inserir</button>
            </form>
        </div>
    </div>
</body>
</html>
