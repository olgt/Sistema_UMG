/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_de_sistema;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import desktop_login.linkDB;
import java.sql.Connection;

/**
 *
 * @author olgt1
 */
public class Estudiante{
    private String nombre;
    private String telefono;
    private String correo;
    private String carnet;
    private String ano_ingreso;
    private String facultad;
    
    public Estudiante(String nombre, String telefono, String correo, 
            String carnet, String ano_ingreso, String carrera){
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.ano_ingreso = ano_ingreso;
        this.carnet = carnet;
        this.facultad = carrera;

    }
    
     public String getCorreo_electronico() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo = correo_electronico;
    }

    public void setNo_celular(String no_celular) {
        this.telefono = no_celular;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getAnio_ingreso() {
        return ano_ingreso;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setAnio_ingreso(String ano_ingreso) {
        this.ano_ingreso = ano_ingreso;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
    
    public void eliminar(){
        this.nombre = null;
        this.carnet = null;
        this.telefono = null;
        this.ano_ingreso = null;
        this.correo = null;
    }

    @Override
    public String toString(){
        return "Estudiantes(" + "Carnet: " + carnet + " Nombre: " + nombre + ")";
    }
    
    public String AgregarEstudianteDB(String nombre, String telefono, String correo, String carnet, String ano_ingreso, String nombre_carrera){
        PreparedStatement statement = null;
        String mensaje;
        
        String sql = "INSERT INTO ESTUDIANTE (nombre, telefono, correo, carnet, ano_ingreso, carrera_id_carrera) VALUES(?,?,?,?,?,"
                + "(SELECT ID_CARRERA FROM CARRERA C WHERE NOMBRE = ?))";
        try{
            statement = linkDB.currentConnection.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, telefono);
            statement.setString(3, correo);
            statement.setString(4, carnet);
            statement.setString(5, ano_ingreso);
            statement.setString(6, nombre_carrera);
            
            //Ejecutamos el Statement
            int recordsInserted = statement.executeUpdate();
            linkDB.currentConnection.commit();
            statement.close();
            
            
            System.out.println("Records Inserted:" + recordsInserted);
            mensaje = "Estudiante Agregado: " + nombre;
            
        } catch(SQLException e){
            mensaje = "Error" + e.getMessage();
        }
        return mensaje;
    }
    
    public String ModificarEstudiante(String nombre, String telefono, String correo, String ano_ingreso, String nombre_carrera, String carnet){
        
        PreparedStatement statement = null;
        String mensaje;
        
        String sql = "UPDATE ESTUDIANTE SET "
                + "NOMBRE = ?,"
                + "TELEFONO = ?,"
                + "CORREO = ?,"
                + "ANO_INGRESO = ?, "
                + "CARRERA_ID_CARRERA = (SELECT ID_CARRERA FROM CARRERA WHERE NOMBRE= ? )"
                + "WHERE CARNET = ?";
        
        try{
            statement = linkDB.currentConnection.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, telefono);
            statement.setString(3, correo);
            statement.setString(4, ano_ingreso);
            statement.setString(5, nombre_carrera);
            statement.setString(6, carnet);

            
            //Ejecutamos el Statement
            int recordsModified = statement.executeUpdate();
            linkDB.currentConnection.commit();
            statement.close();
            
            System.out.println("Items Modified: " + recordsModified);
            mensaje = "Estudiante Modificado: " + carnet;
            
        } catch(SQLException e){
            mensaje = "Error" + e.getMessage();
        }
        
        return mensaje;
    }
    
    public String EliminarEstudiante(String carnet){
        
        PreparedStatement statement = null;
        String mensaje;
        String sql = "DELETE FROM ESTUDIANTE WHERE CARNET = (?)";
        
        try{
            statement = linkDB.currentConnection.prepareStatement(sql);
            statement.setString(1, carnet);

            //Ejecutamos el Statement
            int recordsDeleted = statement.executeUpdate();
            linkDB.currentConnection.commit();
            statement.close();
            
            System.out.println("Items Deleted: " + recordsDeleted);
            mensaje = "Estudiante Eliminado: " + carnet;
            
        } catch(SQLException e){
            mensaje = "Error" + e.getMessage();
        }
        
       return mensaje;
    }
    
}
