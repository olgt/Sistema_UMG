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
    
    public String agregarCurso(Curso curso, Conexion con) throws SQLException{
        
        cls_CursoDAO cursoDAO = new cls_CursoDAO();
        
        try{
            mensaje = cursoDAO.agregarCurso(con.getExistingConnection(), curso);
            System.out.println("Paso 5" + mensaje);
        } catch (Exception e){
            mensaje = mensaje + " " + e.getMessage();
            System.out.println("Paso 6" + mensaje);
        }        
        
        return mensaje;
    }
    
    
    public String modificarCurso(java.sql.Connection con, Curso curso){
        cls_CursoDAO cursoDAO = new cls_CursoDAO();
        
        try{
            mensaje = cursoDAO.modificarCurso(con, curso);
            System.out.println("Paso 5" + mensaje);
        } catch (Exception e){
            mensaje = mensaje + " " + e.getMessage();
            System.out.println("Paso 6" + mensaje);
        }        
        
        return mensaje;
    }
    
    
    public String eliminarCurso(java.sql.Connection con, String nombreCurso){
        cls_CursoDAO cursoDAO = new cls_CursoDAO();
        
        try{
            mensaje = cursoDAO.eliminarCurso(con, nombreCurso);
            System.out.println("Paso 5" + mensaje);
        } catch (Exception e){
            mensaje = mensaje + " " + e.getMessage();
            System.out.println("Paso 6" + mensaje);
        }        
        
        return mensaje;
    }
}
