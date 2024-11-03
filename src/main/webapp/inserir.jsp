<%@ page import="org.common.html.HTMLInput" %>
<%@ page import="org.common.Tabela" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulário de Inserção</title>
    <link rel="stylesheet" href="./css/inserir.css">
</head>
<body cz-shortcut-listen="true">
    <div id="linhaEnfeite"></div>
    <%
        Tabela tabela = (Tabela) request.getAttribute("tabela");
        String tabelaInterface = tabela.getNomeInterface();
        String tabelaBanco = tabela.getNomeBanco();
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
