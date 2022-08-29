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
    
    
    public String modificarEstudiante(Connection con, Estudiante est){
        
        PreparedStatement pst = null;
        String sql = "UPDATE ESTUDIANTE SET "
                + "NOMBRE = (?),"
                + "CELULAR = (?),"
                + "AÑO_INGRESO = (?),"
                + "CORREO = (?),"
                + "PASSWORD = (?) "
                + "WHERE CARNET = (?)";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, est.getNombre());
            pst.setString(2, est.getNo_celular());
            pst.setString(3, est.getAnio_ingreso());
            pst.setString(4, est.getCorreo_electronico());
            pst.setString(5, est.getPassword());
            pst.setString(6, est.getCarnet());


            
            mensaje = "Modficiacion realizada con exito";
            int i = pst.executeUpdate();
            con.commit();
            pst.close();
            System.out.println("Items Modified: " + i);
            
        } catch(SQLException e){
            mensaje = "Error" + e.getMessage();
        }
        
        return mensaje;
    }
    
    
    public String eliminarEstudiante(Connection con, String carnet){
        
        PreparedStatement pst = null;
        String sql = "DELETE FROM ESTUDIANTE WHERE CARNET = (?)";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, carnet);

            
            mensaje = "Eliminacion realizada con exito";
            int i = pst.executeUpdate();
            con.commit();
            pst.close();
            System.out.println("Items Deleted: " + i);
            
        } catch(SQLException e){
            mensaje = "Error" + e.getMessage();
        }
        
       return mensaje;
    }
    
    
    public void mostrarEstudiante(){
        
    }
    
}
