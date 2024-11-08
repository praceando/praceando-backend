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
    <link rel="stylesheet" href="front_core/styles/crud/visualizar.css">
    <link rel="stylesheet" href="front_core/styles/crud/removePopUp.css">
</head>
<body>
    <div class="box">
        <h1><%=tabelaInterface%></h1>
        <h2><%=saida.size()%> Elementos listados</h2>

        <%if(canAlter) { // Se o usuário tem permissão para alterar a tabela
        %>
        <a class="visuBtn" id="novoBtn" href="inserir?tabela=<%=tabelaBanco%>">Novo</a>
        <%}
        %>
        <a class="visuBtn" id="filtrarBtn" href="search-form?tabela=<%=tabelaBanco%>">Filtrar e pesquisar</a>
        <a class="visuBtn" id="voltarBtn" href="home.html">Voltar</a>

        <table class="tabelaSaida">
            <div class="conteudo">
                <tr>
                    <%if (canAlter) { // Se o usuário tem permissão para alterar a tabela
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
                    <td>
                        <%if (canAlter) { // Se o usuário tem permissão para alterar a tabela
                        %>
                        <a class="visuBtn" id="atualizarBtn" <%=tabelaBanco.equals("admin") ? "disabled-" : ""%>href="alterar?tabela=<%=tabelaBanco%>&id=<%=m.getId()%>">
                            <img src="assets/visu/editar.png" alt="editar">
                        </a>
                        <a class="visuBtn botao-excluir" id="removerBtn" <%=tabelaBanco.equals("admin") ? "disabled-" : ""%>data-href="remover?tabela=<%=tabelaBanco%>&id=<%=m.getId()%>">
                            <img src="assets/visu/excluir.png" alt="excluir">
                        </a>
                        <%} %>
                    </td>
                    <%=HTMLGenerator.linhaFromModel(m)%> <!-- Chama o método linhaFromModel da classe HTMLGenerator para gerar a linha da tabela -->
                </tr>
                <%  }
                %>
            </div>
        </table>


    </div>

    <div id="modal-confirmacao" class="modal">
        <div class="modal-conteudo">
            <span id="fechar-modal" class="fechar">&times;</span>
            <div class="corpo-modal">
                <img src="assets/visu/alert.png" alt="Imagem de Confirmação" class="imagem-confirmacao">
                <p>Você deseja mesmo excluir esse registro em <strong><%=tabelaInterface%></strong>?</p>
            </div>
            <button id="confirmar-exclusao">Sim, excluir</button>
            <button id="cancelar-exclusao">Cancelar</button>
        </div>
    </div>
    <script src="front_core/scripts/removerPopUp.js"></script>
</body>
</html>