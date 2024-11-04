<%@ page import="java.util.*" %>
<%@ page import="org.model.Model" %>
<%@ page import="org.common.html.HTMLGenerator" %>
<%@ page import="org.common.Tabela" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%
    // Pegar os parâmetros oriundos do Servlet
    Tabela tabela = (Tabela) request.getAttribute("tabela");
    String tabelaInterface = tabela.getNomeInterface();
    String tabelaBanco = tabela.getNomeBanco();
    String[] colunas = tabela.getColunasInterface();

    List<Model> saida = (List<Model>) request.getAttribute("saida");
    boolean canAlter = (boolean) request.getAttribute("canAlter");
%>

<head>
    <title>Visualizando: <%=tabelaInterface%></title>
    <link rel="stylesheet" href="css/visualizar.css">
</head>
<body>
<div class="box">
    <h1><%=tabelaInterface%></h1>
    <h2><%=saida.size()%> Elementos listados</h2>

    <%if(canAlter) {
    %>
    <a class="visuBtn" id="novoBtn" href="inserir?tabela=<%=tabelaBanco%>">Novo</a>
    <%}
    %>
    <a class="visuBtn" id="filtrarBtn" href="search-form?tabela=<%=tabelaBanco%>">Filtrar e pesquisar</a>
    <a class="visuBtn" id="voltarBtn" href="home.html">Voltar</a>

    <table class="tabelaSaida">
        <div class="conteudo">
            <tr>
                <%if (canAlter) {
                %>
                <th>Ações</th>
                <%}
                %>

                <%for (String coluna : colunas) {
                %>
                <th><%=coluna%></th>
                <%}
                %>
            </tr>
            <%for (Model m : saida) {
            %>
            <tr>
                <%if (canAlter) {
                %>
                <td>
                    <a class="visuBtn" id="atualizarBtn" href="alterar?tabela=<%=tabelaBanco%>&id=<%=m.getId()%>">
                        <img src="assets/editar.png" alt="editar">
                    </a>
                    <a class="visuBtn" id="removerBtn" href="remover?tabela=<%=tabelaBanco%>&id=<%=m.getId()%>">
                        <img src="assets/excluir.png" alt="excluir">
                    </a>
                </td>
                <%}
                %>
                <%=HTMLGenerator.linhaFromModel(m)%>
            </tr>
            <%  }
            %>
        </div>
    </table>
</div>
</body>
</html>