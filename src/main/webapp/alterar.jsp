<%@ page import="org.common.html.HTMLInput" %>
<%@ page import="org.model.Model" %>
<%@ page import="org.common.Tabela" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        // Pegando dados que saíram do Servlet
        Tabela tabela = (Tabela) request.getAttribute("tabela");
        String tabelaInterface = tabela.getNomeInterface();
        String tabelaBanco = tabela.getNomeBanco();

        // Model encontrado para alteração
        Model model = (Model) request.getAttribute("model");
    %>
    <title>Alterando ID <%=model.getId()%> da tabela <%=tabelaInterface%></title>

    <link rel="stylesheet" href="./css/inserir.css">
</head>
<body>

    <!-- Voltar para a página de visualização -->
    <a class="botao-voltar" href="visualizar?tabela=<%=tabelaBanco%>">
        <img src="assets/voltar.png" alt="Voltar">
    </a>

    <p>Alterando ID <%=model.getId()%> da tabela <b><%=tabelaInterface%></b></p>

    <div id="centralizar">
        <div id="caixaInsert">
            <form method="post" action="alterar-done">
                <input type="hidden" name="tabelaNome" value="<%=tabelaBanco%>">
                <!--Gerando formulário de alterar com base no nome da tabela e no model-->
                <%=HTMLInput.getForm(tabelaBanco, model)%>
                <button type="submit" id="botaoInserir">Alterar</button>
            </form>
        </div>
    </div>
</body>
</html>