/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_de_sistema;


import com.sun.jdi.connect.spi.Connection;
import desktop_login.Conexion;
import java.sql.*;



public class cls_CursoBO {
    
    private String mensaje;
    
    public String agregarEstudiante(Curso curso) throws SQLException{
        
        Conexion con = new Conexion();
        cls_CursoDAO cursoDAO = new cls_CursoDAO();
        
        try{
            mensaje = cursoDAO.agregarCurso(con.getConnection("UMG","123456"), curso);
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
