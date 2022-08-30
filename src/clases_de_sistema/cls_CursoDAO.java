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
        String sql = "INSERT INTO CURSO (Nombre, Descripcion, , ID_Seccion) VALUES(?,?,?,?)";
        try{
            pst = Con.prepareStatement(sql);
            pst.setString(1, curso.getNombre());
            pst.setString(2, curso.getDescripcion());
            //TODO: Obtener metodos de seccion y Horario para obtener el registro por medio de nombre
            pst.setString(3, curso.getHorario());
            pst.setString(4, curso.getSeccion());
            
            mensaje = "Insercion realizada con exito";
            int i = pst.executeUpdate();
            Con.commit();
            pst.close();
            System.out.println("Records Inserted:" + i);
            System.out.println("Curso Agregado");
            
        } catch(SQLException e){
            mensaje = "Error" + e.getMessage();
        }
        
        return mensaje;
    }
    
    
    public String modificarCurso(Connection con, Curso curso){
        
        PreparedStatement pst = null;
        String sql = "UPDATE CURSO SET "
                + "NOMBRE = (?),"
                + "DESCRIPCION = (?),"
                + "ID_HORARIO = (?),"
                + "ID_SECCION = (?)"
                + "WHERE CARNET = (?)";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, curso.getNombre());
            pst.setString(2, curso.getDescripcion());
                        //TODO: Obtener metodos de seccion y Horario para obtener el registro por medio de nombre

            pst.setString(3, curso.getHorario());
            pst.setString(4, curso.getSeccion());
            
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
    
    
    public String eliminarCurso(Connection con, String nombreCurso){
        
        PreparedStatement pst = null;
        String sql = "DELETE FROM CURSO WHERE NOMBRE = (?)";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, nombreCurso);

            
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
