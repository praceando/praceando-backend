<%@ page import="org.common.SqlExitDML" %>
<%@ page import="org.common.Tabela" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="front_core/styles/crud/inserirSaida.css">
</head>
<body>
<%
    // Pegando dados que saíram do Servlet
    Tabela tabela = (Tabela) request.getAttribute("tabela");
    String tabelaInterface = tabela.getNomeInterface();
    String tabelaBanco = tabela.getNomeBanco();

    SqlExitDML saida = (SqlExitDML) request.getAttribute("saida");
%>
    <a class="botao-voltar" href="visualizar?tabela=<%=tabelaBanco%>">
        <img src="assets/form/voltar.png" alt="Voltar">
    </a>

    <div class="container">
        <p id="titulo3">Tentou remover ID:<%=request.getParameter("id")%> na tabela '<%=tabelaInterface%>'</p>

        <div class="saida">
            <p id="subtitulo2"><%=saida.toString()%></p>

            <%if (saida.hasErro()) { //Se houver erro
            %>
            <br>
            <p class="fracasso"><%=saida.getErro()%></p>
            <%}
            %>
        </div>
    </div>
</body>
</html>