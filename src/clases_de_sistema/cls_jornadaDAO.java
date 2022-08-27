/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_de_sistema;
import java.sql.*;
import java.sql.Connection;
/**
 *
 * @author V9T2R
 */
public class cls_jornadaDAO {
    private String mensaje;
    
    public String agregarJornada(Connection Con, Jornada jor){
        
        PreparedStatement pst = null;
        String sql = "INSERT INTO ESTUDIANTE (Nombre, Dias) VALUES(?,?,?,?,?,?)";
        try{
            pst = Con.prepareStatement(sql);
            pst.setString(1, jor.getNombre());
            pst.setString(2, jor.getDias());

            
            mensaje = "Insercion realizada con exito";
            int i = pst.executeUpdate();
            Con.commit();
            pst.close();
            System.out.println("Records Inserted:" + i);
            System.out.println("Estudiante Agregado: " + jor.toString());
            
        } catch(SQLException e){
            mensaje = "Error" + e.getMessage();
        }
        
        return mensaje;
    }
    
    
    public String modficiarJornada(){
        return mensaje;
    }
    
    
    public String eliminarJornada(){
       return mensaje;
    }
    
    
    public void mostrarJornada(){
        
    }
    
}
    

