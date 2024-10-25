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
        String tabelaNome = (String) request.getAttribute("tabela");
        List<Model> saida = dao.visualizar();
    %>
    <h1>Visualizando: <%=tabelaNome%></h1>
    <h2><i><%=saida.size()%> Elementos listados...</i></h2>
    <table class="tabelaSaida">
        <tr>
            <%for (String coluna : colunas) {%>
                    <td><%=coluna%></td>
            <%}
            %>
        </tr>
        <%
          for (Model m : saida) {%>
              <tr>
                  <%=m.getRawHTMLRow()%>
              </tr>
        <%  }
        %>
    </table>
</body>
</html>
