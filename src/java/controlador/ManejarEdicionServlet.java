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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 * Operaciones que se realizan luego de presionar el botón guardar al editar. Editar usuario servlet tiene
 * otra función relacionada con mostrarDatos.jsp
 * @author Pathy
 */


public class ManejarEdicionServlet extends HttpServlet {

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
       
        String id = request.getParameter("txtId"); // txtId es el parametro que viene de editarUsuario.jsp
        String nombre = request.getParameter("txtNombre");
        String edad = request.getParameter("txtEdad");
        
        if(id.isEmpty() || nombre.isEmpty() || edad.isEmpty()){
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
        }
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
