<%-- 
    Document   : AgregarUsuario
    Created on : 27-sep-2016, 23:50:47
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
        <form action="agregarUsuario.do" method="post">
            <table>
                <tr>
                    <td> Id
                    <input type="number" name="txtId">
                </tr>  
                <tr>  
                    <td> Nombre
                    <input type="text" name="txtNombre">
                 </tr>  
                 <tr>  
                    <td> Edad
                    <input type="number" name="txtEdad">
                 </tr>   
            </table> 
            <input type="Submit" value="Guardar">
            <input type="Reset" value="Limpiar">
        </form>    
       
        
    </body>
</html>
