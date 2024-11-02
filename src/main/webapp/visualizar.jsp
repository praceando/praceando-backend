<%@ page import="java.util.*" %>
<%@ page import="org.model.Model" %>
<%@ page import="org.common.html.HTMLGenerator" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%
    // Pegar os parâmetros oriundos do Servlet
    String tabelaInterface = (String) request.getAttribute("tabelaNome");
    String tabelaBanco = request.getParameter("tabela");

    String[] colunas = HTMLGenerator.getColunasInterface(tabelaBanco);
    List<Model> saida = (List<Model>) request.getAttribute("saida");
    boolean canAlter = (boolean) request.getAttribute("canAlter");
%>

<head>
    <title>Visualizando: <%=tabelaInterface%></title>
</head>
<body>
    <h1>Visualizando: <%=tabelaInterface%></h1>
    <h2><i><%=saida.size()%> Elementos listados...</i></h2>

    <%if(canAlter) {
    %>
        <a class="visuBtn" id="novoBtn" href="inserir?tabela=<%=tabelaBanco%>">Novo</a>
    <%}
    %>
    <a href="search-form?tabela=<%=tabelaBanco%>">Filtrar e pesquisar</a>

    <table class="tabelaSaida">
        <tr>
            <%if (canAlter) {
            %>
                <td>Ações</td>
                <td>Ações</td>
            <%}
            %>

            <%for (String coluna : colunas) {
            %>
                    <td><%=coluna%></td>
            <%}
            %>
        </tr>
        <%for (Model m : saida) {
        %>
              <tr>
                  <%if (canAlter) {
                  %>
                  <td><a class="visuBtn" id="atualizarBtn" href="alterar?tabela=<%=tabelaBanco%>&id=<%=m.getId()%>">Alterar</a></td>
                  <td><a class="visuBtn" id="removerBtn" href="remover?tabela=<%=tabelaBanco%>&id=<%=m.getId()%>">Excluir</a></td>
                  <%}
                  %>

                  <%=HTMLGenerator.linhaFromModel(m)%>
              </tr>
        <%  }
        %>
    </table>
</body>
</html>
