/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pathy
 */
public class Conexion {
    protected Statement st;
    private Connection con;

    public Conexion() {
    }
    
    public Connection getConexion(){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ejemplo", "postgres", "admin");
            st = con.createStatement();
            return con;
        }catch(SQLException ex){
            System.out.println("Error al conectar "+ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Error "+ex.getMessage());
        }
        return con;
    }
    
    public Connection cerrarConexion(){
        try{
            con.close();
        }catch(Exception ex){
            System.out.println("Error al cerrar la conexión "+ ex.getMessage());
        }
        return con;
    }
    
    
}
