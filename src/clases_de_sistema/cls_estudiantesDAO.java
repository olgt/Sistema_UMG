/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_de_sistema;

import java.sql.*;
import java.sql.Connection;

public class cls_estudiantesDAO {

    private String mensaje;
    
    public String agregarEstudiante(Connection Con, Estudiante est){
        
        PreparedStatement pst = null;
        String sql = "INSERT INTO ESTUDIANTE (Nombre, Celular, Carnet, Año_Ingreso, Correo, Password) VALUES(?,?,?,?,?,?)";
        try{
            pst = Con.prepareStatement(sql);
            pst.setString(1, est.getNombre());
            pst.setString(2, est.getNo_celular());
            pst.setString(3, est.getCarnet());
            pst.setString(4, est.getAnio_ingreso());
            pst.setString(5, est.getCorreo_electronico());
            pst.setString(6, est.getPassword());
            
            mensaje = "Insercion realizada con exito";
            int i = pst.executeUpdate();
            Con.commit();
            pst.close();
            System.out.println("Records Inserted:" + i);
            System.out.println("Estudiante Agregado: " + est.toString());
            
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
