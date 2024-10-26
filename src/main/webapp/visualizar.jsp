<%@ page import="org.dao.DAOGeneric" %>
<%@ page import="java.util.*" %>
<%@ page import="org.model.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Saída da Visualização da tabela Tag</title>
</head>
<body>
    <%
        DAOGeneric<Model> dao = (DAOGeneric<Model>) request.getAttribute("dao");
        String[] colunas = (String[]) request.getAttribute("colunas");
        List<Model> saida = dao.visualizar();
    %>
    <h1>Visualizando: <%=dao.getNome()%></h1>
    <h2><i><%=saida.size()%> Elementos listados...</i></h2>
    <a class="visuBtn" id="novoBtn" href="redirect?tabela=<%=dao.getNome()%>&opcao=inserir">Novo</a>

    <table class="tabelaSaida">
        <tr>
            <td>Ações</td>
            <td>Ações</td>
            <%for (String coluna : colunas) {%>
                    <td><%=coluna%></td>
            <%}
            %>
        </tr>
        <%
          for (Model m : saida) {%>
              <tr>
                  <td><a class="visuBtn" id="atualizarBtn" href="atualizar?tabela=<%=dao.getNome()%>&id=<%=m.getId()%>">Atualizar</a></td>
                  <td><a class="visuBtn" id="removerBtn" href="remover?tabela=<%=dao.getNome()%>&id=<%=m.getId()%>">Excluir</a></td>
                  <%=m.getRawHTMLRow()%>
              </tr>
        <%  }
        %>
    </table>
</body>
</html>
