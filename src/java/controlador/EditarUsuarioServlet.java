/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import datos.CrudUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 *
 * @author Pathy
 * Recibe el id de mostrarDatos.jsp y luego se crea el atributo que consulta los datos del usuario
 * de acuerdo al id recibido. La lista con los datos obtenidos de acuerdo al id, se recorre en 
 * editarUsuario.jsp. Para concretar la edición (operación de edición al presionar el botón,
 * se utiliza el servlet manejar edición
 */
@WebServlet(name = "EditarUsuarioServlet", urlPatterns = {"/editar.do"})
public class EditarUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        String idTemp = request.getParameter("id"); //este id es el que se le pasa desde mostrarDatos.jsp
        
         CrudUsuario crudUsuario = new CrudUsuario();
        
        System.out.println("EL ID ES "+idTemp);
        request.getSession().setAttribute("listarUsuariosPorId", crudUsuario.listarUsuariosPorId(Integer.parseInt(idTemp)));
        request.getRequestDispatcher("EditarUsuario.jsp").forward(request, response);
        
        /*if(id.isEmpty() || nombre.isEmpty() || edad.isEmpty()){
            String error = "Campos vacios";
            request.getSession().setAttribute("error", error);
        }else{
            Usuario usu = new Usuario();
            usu.setId(Integer.parseInt(id));
            usu.setNombre(nombre);
            usu.setEdad(Integer.parseInt(edad));
            CrudUsuario crudUsuario = new CrudUsuario();
            crudUsuario.editarUsuario(usu);
            
            if(crudUsuario.editarUsuario(usu) == true){
                String mensaje = "Se editó correctamente";
                request.getSession().setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("Exito.jsp").forward(request, response);
            }else{
                String error = "Error al editar usuario";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
