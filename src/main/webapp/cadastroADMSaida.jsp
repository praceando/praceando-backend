<%@ page import="java.util.Arrays" %>
<%@ page import="org.common.SqlExitDML" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Saída do cadastro</title>
    <link rel="stylesheet" href="front_core/styles/crud/inserirSaida.css">
</head>
<body cz-shortcut-listen="true">
    <%
        // Pegando dados que saíram do Servlet
        boolean[] status = (boolean[]) request.getAttribute("status");
        boolean dbAccessValido = (boolean) request.getAttribute("dbAccessValido");
        SqlExitDML saidaInsert = (SqlExitDML) request.getAttribute("saidaInsert");

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");


        // Verificando se a senha e o email são válidos
        String[] avisos = new String[]{
                status[0] ? "Senha inválida, precisa ter 8 caracteres E uma letra maiúscula" : null,
                status[1] ? "E-mail inválido, precisa ser um e-mail válido da Germinare" : null,
                status[2] ? "Usuário de mesmo e-mail já cadastrado": null
        };
    %>



    <div class="container">
        <p id="titulo1">Tentou cadastrar '<%=email%>', com senha '<%="*".repeat(senha.length())%>' </p>

        <!-- Saída e avisos -->
        <% // Se o código de acesso fornecido for inválido
            if (dbAccessValido) { // Se o código de acesso fornecido for inválido


                if (Arrays.equals(status, new boolean[]{false, false, false})) { // Se tudo estiver OK, mostre a mensagem de saída
        %>
        <p class="subtitulo2"><%=saidaInsert.toString()%></p>
        <%
        } else { // Se houver algum aviso, exibe-os
            for (String av : avisos) {
                if (av != null) {
        %>
        <p class="subtitulo2 fracasso" style="color: red"><%=av%></p>
        <%
                    }
                }
            }
        } else {%> <!-- Se o código de acesso fornecido for inválido -->
        <p class="subtitulo2 fracasso">Código de acesso inválido</p>
        <%}
        %>
    </div>

    <a class="botao-voltar" href="visualizar?tabela=admin">
        <img src="assets/form/voltar.png" alt="Voltar">
    </a>
</body>
</html>