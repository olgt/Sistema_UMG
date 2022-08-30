/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_de_sistema;


import desktop_login.Conexion;
import java.sql.*;



public class cls_estudiantesBO {
    
    private String mensaje;
    
    public String agregarEstudiante(Estudiante est) throws SQLException{
        
        Conexion con = new Conexion();
        cls_estudiantesDAO Est = new cls_estudiantesDAO();
        
        try{
            mensaje = Est.agregarEstudiante(con.getExistingConnection(), est);
            System.out.println("Paso 5" + mensaje);
        } catch (Exception e){
            mensaje = mensaje + " " + e.getMessage();
            System.out.println("Paso 6" + mensaje);
        }        
        
        return mensaje;
    }
    
    
    public String modificarEstudiante(Connection con, Estudiante est){
        cls_estudiantesDAO estDAO = new cls_estudiantesDAO();
        
        try{
            mensaje = estDAO.modificarEstudiante(con, est);
            System.out.println("Paso 5" + mensaje);
        } catch (Exception e){
            mensaje = mensaje + " " + e.getMessage();
            System.out.println("Paso 6" + mensaje);
        }        
        
        return mensaje;
    }
    
    
    public String eliminarEstudiante(Connection con, String carnet){
        cls_estudiantesDAO estDAO = new cls_estudiantesDAO();
        
        try{
            mensaje = estDAO.eliminarEstudiante(con, carnet);
            System.out.println("Paso 5" + mensaje);
        } catch (Exception e){
            mensaje = mensaje + " " + e.getMessage();
            System.out.println("Paso 6" + mensaje);
        }        
        
        return mensaje;
    }
    
    
    public void mostrarEstudiante(){
        
    }
}
