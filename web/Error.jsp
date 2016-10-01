<%-- 
    Document   : Error
    Created on : 27-sep-2016, 23:05:50
    Author     : Pathy
--%>
<%
    String error = (String) request.getSession().getAttribute("error");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Ha ocurido un error ! <%=error%></h1>
        <a href="listarUsuario.do">Volver al menu principal </a>
    </body>
</html>
