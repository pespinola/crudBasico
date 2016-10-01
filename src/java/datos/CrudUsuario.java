/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;

import datos.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author Pathy
 */
public class CrudUsuario extends Conexion{
    
        private ResultSet rs;
        
        public CrudUsuario(){
            getConexion();
        }
        
        public ArrayList<Usuario> listarUsuarios(){
           
            ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
            
            try{
                String sql = "Select * from usuario order by id";
                rs = st.executeQuery(sql);
                while(rs.next()){
                    listaUsuario.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getInt(3)));
                }
                return listaUsuario;
            }catch(SQLException ex){
                System.out.println("Error al listar usuarios "+ex.getMessage());
            }
            return listaUsuario;
        }
        
          public ArrayList<Usuario> listarUsuariosPorId(int id){
           
            ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
            
            try{
                String sql = "Select * from usuario where id = '"+id+"' ";
                rs = st.executeQuery(sql);
                while(rs.next()){
                    listaUsuario.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getInt(3)));
                }
                return listaUsuario;
            }catch(SQLException ex){
                System.out.println("Error al listar usuarios "+ex.getMessage());
            }
            return listaUsuario;
        }
        
        
        public boolean agregarUsuario(Usuario usu){
            try{
                String sql = "Insert into usuario values ('"+usu.getId()+"', '"+usu.getNombre()+"', '"+usu.getEdad()+ "')";
                st.executeUpdate(sql);  //para todos menos consulta se usa executeUpdate
                return true;
            }catch(SQLException ex){
                System.out.println("Error al agregar "+ex.getMessage());
                return false;
            }
        }
        
        public boolean editarUsuario(Usuario usu){
            try{
                String sql = "Update usuario set nombre = '"+usu.getNombre()+"', edad = '"+usu.getEdad()+"' where id = '"+usu.getId()+"'";
                st.executeUpdate(sql);
                return true;
            }catch(SQLException ex){
                System.out.println("Error al editar "+ex.getMessage());
                return false;
            }
        }
        
        public boolean eliminarUsuario(int id){
            try{
                String sql = "Delete from usuario where id = '"+id+"' ";
                st.executeUpdate(sql); //para insert, delete, update se usa executeUpdate. Para consultar executeQuery
                return true;
            }catch(SQLException ex){
                System.out.println("Error al eliminar "+ex.getMessage());
                return false;
            }
        }
    
}
