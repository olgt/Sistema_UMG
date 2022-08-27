/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_de_sistema;


import com.sun.jdi.connect.spi.Connection;
import desktop_login.Conexion;
import java.sql.*;



public class cls_AsignacionBO {
    
    private String mensaje;
    
    public String agregarEstudiante(Asignacion asignacion) throws SQLException{
        
        Conexion con = new Conexion();
        cls_AsignacionDAO asignacionDAO = new cls_AsignacionDAO();
        
        try{
            mensaje = asignacionDAO.agregarAsignacion(con.getConnection("UMG","123456"), asignacion);
            System.out.println("Paso 5" + mensaje);
        } catch (SQLException e){
            mensaje = mensaje + " " + e.getMessage();
            System.out.println("Paso 6" + mensaje);
        }        
        
        return mensaje;
    }
    
    
    public String modificarEstudiante(Curso curso){
        return mensaje;
    }
    
    
    public String eliminarEstudiante(int id){
       return mensaje;
    }
    
    
    public void mostrarEstudiante(){
        
    }
}
