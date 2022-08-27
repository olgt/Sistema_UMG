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
public class cls_jornadaBO {
    private String mensaje;
    
    public String agregarJornada(Jornada jor) throws SQLException{
        
        Conexion con = new Conexion();
        cls_jornadaDAO jor = new cls_jornadaDAO();
        
        try{
            mensaje = jor.agregarJornada(con.getConnection("UMG","123456"), jor);
            System.out.println("Paso 5" + mensaje);
        } catch (SQLException e){
            mensaje = mensaje + " " + e.getMessage();
            System.out.println("Paso 6" + mensaje);
        }        
        
        return mensaje;
    }
    
    
   public String modificarJornada(){
        return mensaje;
    }
    
    
    public String eliminarJornada(){
       return mensaje;
    }
    
    
    public void mostrarJornada(){
        
    }
    
}

