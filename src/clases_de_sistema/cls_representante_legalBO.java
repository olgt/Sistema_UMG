/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_de_sistema;

import com.sun.jdi.connect.spi.Connection;
import desktop_login.Conexion;
import java.sql.*;
/**
 *
 * @author V9T2R
 */
public class cls_representante_legalBO {
    
    private String mensaje;
    
    public String agregarRepresentanteLegal(Representante_legal rep) throws SQLException{
        
        Conexion con = new Conexion();
        cls_representante_legalDAO rep = new cls_representante_legalDAO();
        
        try{
            mensaje = rep.agregarRepresentante_legal(con.getConnection("UMG","123456"), rep);
            System.out.println("Paso 5" + mensaje);
        } catch (SQLException e){
            mensaje = mensaje + " " + e.getMessage();
            System.out.println("Paso 6" + mensaje);
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