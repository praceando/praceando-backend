<%@ page import="java.util.Map" %>
<%@ page import="org.common.Tabela" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //Getters
  Tabela tabela = (Tabela) request.getAttribute("tabela");
  String tabelaInterface = tabela.getNomeInterface();
  String tabelaBanco = tabela.getNomeBanco();

  Map<String, String> colunas = tabela.getColunas();
%>

<html>
<head>
  <title>Pesquisar</title>
  <link rel="stylesheet" href="css/search.css">
</head>
<body cz-shortcut-listen="true">
  <a class="botao-voltar" href="visualizar?tabela=<%=tabelaBanco%>">
    <img src="assets/voltar.png" alt="Voltar">
  </a>

  <p id="titulo">Pesquisar: <b><%=tabelaInterface%></b></p>

  <div class="container">
    <form action="search" class="form-pesquisa" method="get">
      <input hidden="hidden" name="tabela" value="<%=tabelaBanco%>">

      <div class="input-container">
        <label for="colunaFiltro" id="pesquisarNaColuna">Pesquisar na coluna </label>
        <select name="colunaFiltro" class="selecao" id="colunaFiltro" required="">

          <%for (Map.Entry<String, String> coluna : colunas.entrySet()) {
            // colunas_banco     -> chaves
            // colunas_interface -> valores
          %>
          <option value="<%=coluna.getKey()%>"><%=coluna.getValue()%></option>
          <%}
          %>
        </select>

        <br>

        <label for="filtro" id="por">por: </label>
        <input type="text" class="pesquisaTxt" name="filtro" id="filtro" placeholder="Filtro...">

        <br>

        <label for="orderBy" id="EOrdenarPor">E ordenar por: </label>
        <select name="orderBy" class="selecao" id="orderBy" required="">

          <%for (Map.Entry<String, String> coluna : colunas.entrySet()) {
            // colunas_banco     -> chaves
            // colunas_interface -> valores
          %>
          <option value="<%=coluna.getKey()%>"><%=coluna.getValue()%></option>
          <%}
          %>

        </select>

        <br>

        <label for="orderType" id="emOrdem">em ordem</label>
        <select name="orderType" class="selecao" id="orderType">
          <option class="crescente" value="asc">crescente</option>
          <option class="decrescente" value="desc">decrescente</option>
        </select>

        <br>

        <label for="incluirNDef" id="NaoDefinidos">Não definidos?</label>
        <input type="checkbox" class="checkbox-arredondado" name="incluirNDef" id="incluirNDef" value="sim" checked="">

        <input type="submit" value="Pesquisar" id="pesquisar">
      </div>
    </form>
  </div>
</body>
</html>