<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : EditarUsuario
    Created on : 29-sep-2016, 17:09:32
    Author     : Pathy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="lista" items="${listarUsuariosPorId}">
            <form action="edicion.do" method="post">
                <table>
                    <tr>
                        <td> Id
                            <input type="number" name="txtId" value="${lista.id}">
                    </tr>  
                    <tr>  
                        <td> Nombre
                            <input type="text" name="txtNombre" value="${lista.nombre}">
                    </tr>  
                    <tr>  
                        <td> Edad
                            <input type="number"  name="txtEdad" value="${lista.edad}">
                    </tr>   
                </table> 
                <input type="Submit" value="Guardar">
                <input type="Reset" value="Limpiar">
            </form>    
       </c:forEach>
    </body>
</html>
