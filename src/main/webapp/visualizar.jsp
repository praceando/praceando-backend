<%@ page import="org.dao.DAOGeneric" %>
<%@ page import="java.util.*" %>
<%@ page import="org.model.Model" %>
<%@ page import="org.common.html.HTMLGenerator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    DAOGeneric<Model> dao = (DAOGeneric<Model>) request.getAttribute("dao");
    String[] colunas = (String[]) request.getAttribute("colunas");
    List<Model> saida = dao.visualizar();

    boolean canAlter = !dao.isReadOnly() && !dao.getNome().equals("admin");
%>

<head>
    <title>Visualizando: <%=dao.getNome()%></title>
</head>
<body>
    <h1>Visualizando: <%=dao.getNome()%></h1>
    <h2><i><%=saida.size()%> Elementos listados...</i></h2>

    <%if(canAlter) {
    %>
        <a class="visuBtn" id="novoBtn" href="redirect?tabela=<%=dao.getNome()%>&opcao=inserir">Novo</a>
    <%}
    %>

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
                  <td><a class="visuBtn" id="atualizarBtn" href="alterar?tabela=<%=dao.getNome()%>&id=<%=m.getId()%>">Alterar</a></td>
                  <td><a class="visuBtn" id="removerBtn" href="remover?tabela=<%=dao.getNome()%>&id=<%=m.getId()%>">Excluir</a></td>
                  <%}
                  %>

                  <%=HTMLGenerator.linhaFromModel(m)%>
              </tr>
        <%  }
        %>
    </table>
</body>
</html>
