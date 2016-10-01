<%-- 
    Document   : Exito
    Created on : 29-sep-2016, 16:27:00
    Author     : Pathy
--%>

<% 
    String mensaje = (String)request.getSession().getAttribute("mensaje");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exito</title>
    </head>
    <body>
        <h1>Enhorabuena: <%=mensaje%>  </h1>
        <a href="listarUsuario.do">Volver al menú principal</a>
    </body>
</html>
