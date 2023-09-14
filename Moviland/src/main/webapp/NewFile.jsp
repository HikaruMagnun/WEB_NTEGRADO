
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostrar Cookie</title>
</head>
<body>
    <h1>Valor de la Cookie "user"</h1>
    <%
    String usuario = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("user".equals(cookie.getName())) {
                usuario = cookie.getValue();
                break;
            }
        }
    }
    %>
    <p>El valor de la cookie "user" es: <%= usuario %></p>
</body>
</html>
