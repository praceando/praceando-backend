<%@ page import="org.model.Avatar" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<Avatar> avatares = (List<Avatar>) request.getAttribute("Avatar");
    %>

    <h1>Visualizando avatares</h1>
    <%
        for (int i = 0; i < avatares.size(); i++) {
            Avatar av = avatares.get(i);
    %>
        <div class="avatar-container">
            <h2>Avatar: <%=av.getId_avatar()%></h2>
            <img src="data:image/png;base64,<%=av.getB64_avatar()%>" alt="">
        </div>
    <%
        }
    %>
</body>
</html>
