<%@ page import="java.util.Map" %>
<%@ page import="org.common.SqlExitDML" %>
<%@ page import="org.common.Tabela" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%
        //Getters
    Tabela tabela = (Tabela) request.getAttribute("tabela");
    String tabelaInterface = tabela.getNomeInterface();
    String tabelaBanco = tabela.getNomeBanco();

    Map<String, String> params = (Map<String, String>) request.getAttribute("params");
    SqlExitDML saida = (SqlExitDML) request.getAttribute("saida");
    %>

    <head>
        <title>Saída de Inserção</title>
        <link rel="stylesheet" href="css/inserirSaida.css">
    </head>

    <body cz-shortcut-listen="true">

    <a class="botao-voltar" href="visualizar?tabela=<%=tabelaBanco%>">
        <img src="assets/voltar.png" alt="Voltar">
    </a>

    <div class="saida">
        <h2>Saída:</h2>
        <p id="subtitulo2" class="<%=saida.getCodigo() == 1 ? "sucesso" : "erro"%>"><%=saida.toString()%></p>

        <%if (saida.hasErro()) { //Se hover erro, exibe o erro
        %>
        <br>
        <p><%=saida.getErro()%></p>
        <%}
        %>
    </div>

    <p id="titulo1">Tabela <b><%=tabelaInterface%></b></p>

    <div id="traco"></div>

    <table class="container">
        <thead>
        <tr>
            <th>Nome</th>
            <th>Valor</th>
        </tr>
        </thead>
        <tbody>
        <%for (Map.Entry<String, String> linha : params.entrySet()) { //Percorre as linhas da tabela
        %>
        <tr>
            <td>
                <%=linha.getKey()%>
            </td>
            <td>
                <%=linha.getValue()%>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    </body>
</html>