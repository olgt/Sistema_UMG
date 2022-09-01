/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_de_sistema;

import desktop_login.linkDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author olgt1
 */
public class Curso {
    private String nombre;
    private String descripcion;
    private String facultad;
    
    public Curso(String nombre, String descripcion, String facultad){
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.facultad = facultad;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }
    
    public String getFacultad(){
        return this.facultad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
        
    public void eliminar(){
        this.nombre = null;
        this.descripcion = null;
    }
  
    public String AgregarCursoDB(String nombre, String descripcion, String nombre_facultad){
        PreparedStatement statement = null;
        String mensaje;
        
        String sql = "INSERT INTO CURSO (nombre, descripcion, FACULTAD_id_Facultad) "
                + "VALUES(?,?,"
                + "(SELECT ID_FACULTAD FROM FACULTAD F WHERE NOMBRE = ?))";
        try{
            statement = linkDB.currentConnection.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, descripcion);
            statement.setString(3, nombre_facultad);
            
            //Ejecutamos el Statement
            int recordsInserted = statement.executeUpdate();
            linkDB.currentConnection.commit();
            statement.close();
            
            System.out.println("Records Inserted:" + recordsInserted);
            mensaje = "Curso Agregado: " + nombre;
            
        } catch(SQLException e){
            mensaje = "Error" + e.getMessage();
        }
        return mensaje;
    }
    
    public String ModificarCurso(String nuevoNombre, String descripcion, String nombreActual){
        
        PreparedStatement statement = null;
        String mensaje;
        
        String sql = "UPDATE CURSO SET "
                + "NOMBRE = ?,"
                + "DESCRIPCION = ? "
                + "WHERE NOMBRE = ?";
        
        try{
            statement = linkDB.currentConnection.prepareStatement(sql);
            statement.setString(1, nuevoNombre);
            statement.setString(2, descripcion);
            statement.setString(3, nombreActual);
            
            //Ejecutamos el Statement
            int recordsModified = statement.executeUpdate();
            linkDB.currentConnection.commit();
            statement.close();
            
            System.out.println("Items Modified: " + recordsModified);
            mensaje = "Curso Modificado: " + nuevoNombre;
            
        } catch(SQLException e){
            mensaje = "Error" + e.getMessage();
        }
        
        return mensaje;
    }
    
    public String EliminarCurso(String nombre){
        
        PreparedStatement statement = null;
        String mensaje;
        String sql = "DELETE FROM CURSO WHERE NOMBRE = ?";
        
        try{
            statement = linkDB.currentConnection.prepareStatement(sql);
            statement.setString(1, nombre);

            //Ejecutamos el Statement
            int recordsDeleted = statement.executeUpdate();
            linkDB.currentConnection.commit();
            statement.close();
            
            System.out.println("Items Deleted: " + recordsDeleted);
            mensaje = "Curso  Eliminado: " + nombre;
            
        } catch(SQLException e){
            mensaje = "Error" + e.getMessage();
        }
        
       return mensaje;
    }
    
}
