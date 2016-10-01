<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : MostrarDatos
    Created on : 27-sep-2016, 23:05:36
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
        <h1>Lista de Usuarios</h1>
         <div>
            <table cellpadding = "10">
                <tr> 
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                </tr>
                <c:forEach var="lista" items="${listaUsuario}">
                    <tr>
                        <td>${lista.id}</td>
                        <td>${lista.nombre}</td>
                        <td>${lista.edad}</td>
                        <td>
                            <a href="editar.do?id=${lista.id}">Editar</a> <!-- el nombre del parametro que se le pasa es id, no txtId-->
                            <a href="eliminar.do?id=${lista.id}">Eliminar</a>
                        <td>    
                    </tr>  
                </c:forEach>
            </table>
          </div>
          <div>
              <a href="AgregarUsuario.jsp">Registrar Usuario</a>
          </div>    
    </body>
</html>
