<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="erroNoBancos.jsp" %>


<%
    String tabelaNome = (String) session.getAttribute("tabelaNome");
    String acao = (String) session.getAttribute("acao");
    String idDelete = (String) session.getAttribute("idDelete");
%>
<html>
<head>
</head>
<body>
    <p>VAMOOOOO BORA FAZER <%= acao %> NA <%= tabelaNome %> no ID <%= idDelete %></p>
    <p>Versão 2</p>
</body>
</html>
