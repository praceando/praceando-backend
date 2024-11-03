<%@ page import="java.util.Map" %>
<%@ page import="org.common.Tabela" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    Tabela tabela = (Tabela) request.getAttribute("tabela");
    String tabelaInterface = tabela.getNomeInterface();
    String tabelaBanco = tabela.getNomeBanco();

    Map<String, String> colunas = tabela.getColunas();
  %>
  <h1>Pesquisar: <%=tabelaInterface%></h1>

  <div class="search-container">
    <form action="search" class="form-pesquisa" method="get">
      <input hidden="hidden" name="tabela" value="<%=tabelaBanco%>">

      <div class="input-container">
        <label for="colunaFiltro">Pesquisar na coluna </label>
        <select name="colunaFiltro" class="selecao" id="colunaFiltro" required>
          <%for (Map.Entry<String, String> coluna : colunas.entrySet()) {
            // colunas_banco     -> chaves
            // colunas_interface -> valores
          %>
          <option value="<%=coluna.getKey()%>"><%=coluna.getValue()%></option>
          <%}
          %>
        </select>

        <label for="filtro">por: </label>
        <input type="text" class="pesquisaTxt" name="filtro" id="filtro" placeholder="Filtro...">

        <br>

        <label for="orderBy">E ordenar por: </label>
        <select name="orderBy" class="selecao" id="orderBy" required>
          <%for (Map.Entry<String, String> coluna : colunas.entrySet()) {
            // colunas_banco     -> chaves
            // colunas_interface -> valores
          %>
            <option value="<%=coluna.getKey()%>"><%=coluna.getValue()%></option>
          <%}
          %>
        </select>

        <label for="orderType">em ordem</label>
        <select name="orderType" class="selecao" id="orderType">
          <option class="crescente" value="asc">crescente</option>
          <option class="decrescente" value="desc">decrescente</option>
        </select>

        <br>

        <label for="incluirNDef">Não definidos?</label>
        <input type="checkbox" class="checkbox-arredondado" name="incluirNDef" id="incluirNDef" value="sim" checked>

        <input type="submit" value="Pesquisar">
      </div>
    </form>
  </div>
</body>
</html>
