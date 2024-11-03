<%@ page import="org.common.html.HTMLInput" %>
<%@ page import="org.common.Tabela" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Formulário de Inserção</title>
        <link rel="stylesheet" href="./css/inserir.css">
    </head>
    <body cz-shortcut-listen="true">
    <%
        Tabela tabela = (Tabela) request.getAttribute("tabela");
        String tabelaInterface = tabela.getNomeInterface();
        String tabelaBanco = tabela.getNomeBanco();
    %>
    <a class="botao-voltar" href="visualizar?tabela=<%=tabelaBanco%>">
        <img src="assets/voltar.png" alt="Voltar">
    </a>

    <p>Formulário de inserção: <b><%=tabelaInterface%></b></p>
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
