/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_de_sistema;

import java.sql.*;
import java.sql.Connection;

public class cls_CursoDAO {

    private String mensaje;
    
    public String agregarCurso(Connection Con, Curso curso){
        
        PreparedStatement pst = null;
        //TODO: Modificar sentencia SQL
        String sql = "INSERT INTO ESTUDIANTE (Nombre, Celular, Carnet, Año_Ingreso, Correo, Password) VALUES(?,?,?,?,?,?)";
        try{
            pst = Con.prepareStatement(sql);
            pst.setString(1, curso.getNombre());
            pst.setString(2, curso.getTemas());
            pst.setString(3, curso.getDescripcion());
            
            mensaje = "Insercion realizada con exito";
            int i = pst.executeUpdate();
            Con.commit();
            pst.close();
            System.out.println("Records Inserted:" + i);
            System.out.println("Curso Agregado: " + curso.toString());
            
        } catch(SQLException e){
            mensaje = "Error" + e.getMessage();
        }
        
        return mensaje;
    }
    
    
    public String modficiarEstudiante(){
        return mensaje;
    }
    
    
    public String eliminarEstudiante(){
       return mensaje;
    }
    
    
    public void mostrarEstudiante(){
        
    }
    
}
