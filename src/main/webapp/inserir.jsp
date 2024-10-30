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
        String tabelaNome = request.getParameter("tabela");
    %>
    <p>Formulário de inserção: <span id="gradiente"><%=tabelaNome%></span></p>
    <div id="centralizar">
        <div id="caixaInsert">
            <form method="post" action="inserir">
                <input type="hidden" name="tabelaNome" value="<%=tabelaNome%>">
                <%=HTMLInput.getForm(tabelaNome)%>
                <button type="submit" id="botaoInserir">Inserir</button>
            </form>
        </div>
    </div>
</body>
</html>
