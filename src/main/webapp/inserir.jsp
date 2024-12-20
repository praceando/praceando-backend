<%@ page import="org.common.html.HTMLInput" %>
<%@ page import="org.common.Tabela" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%
        // Pegando dados que saíram do Servlet
        Tabela tabela = (Tabela) request.getAttribute("tabela");
        String tabelaInterface = tabela.getNomeInterface();
        String tabelaBanco = tabela.getNomeBanco();
    %>
    <head>
        <title>Inserindo um novo registro em <%=tabelaInterface%></title>
        <link rel="stylesheet" href="./front_core/styles/crud/inserir.css">
    </head>
    <body cz-shortcut-listen="true">
    <a class="botao-voltar" href="visualizar?tabela=<%=tabelaBanco%>">
        <img src="assets/form/voltar.png" alt="Voltar">
    </a>

    <!-- Cabeçalho -->
    <p>Inserindo um novo registro em: <b><%=tabelaInterface%></b></p>
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