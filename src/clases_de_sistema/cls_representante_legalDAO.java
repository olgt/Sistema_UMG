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
public class cls_representante_legalDAO {
    private String mensaje;
    
    public String agregarRepresentante_legal(Connection Con, Representante_legal rep){
        
        PreparedStatement pst = null;
        String sql = "INSERT INTO ESTUDIANTE (Nombre, Apellido, Celular, Carnet, Año_Ingreso, Correo, Password) VALUES(?,?,?,?,?,?)";
        try{
            pst = Con.prepareStatement(sql);
            pst.setString(1, rep.getNombre());
            pst.setString(2, rep.getApellido());
            pst.setString(3, rep.getId());
            pst.setString(4, rep.getCelular());
            pst.setString(5, rep.getAnio_ingreso());
            pst.setString(6, rep.getCorreo_electronico());
            pst.setString(7, rep.getPassword());
            
            mensaje = "Insercion realizada con exito";
            int i = pst.executeUpdate();
            Con.commit();
            pst.close();
            System.out.println("Records Inserted:" + i);
            System.out.println("Estudiante Agregado: " + rep.toString());
            
        } catch(SQLException e){
            mensaje = "Error" + e.getMessage();
        }
        
        return mensaje;
    }
    
    
    public String modficiarRepresentante_legal(){
        return mensaje;
    }
    
    
    public String eliminarRepresentante_Legal(){
       return mensaje;
    }
    
    
    public void mostrarRepresentante_legal(){
        
    }
    
}
    

