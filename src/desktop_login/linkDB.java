/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop_login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author olgt1
 */
public class linkDB {
 
    public static Connection currentConnection = null;
    public static String login = "UMG";
    public static  String clave = "123456";
    private static String url= "jdbc:oracle:thin:@localhost:1521:xe";

    
    public static Connection getConnection(String p_login, String p_clave) throws SQLException{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            currentConnection= DriverManager.getConnection(url, p_login, p_clave);
            currentConnection.setAutoCommit(false);
            if(currentConnection != null){
                JOptionPane.showMessageDialog (null, "Conexion exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Error de Conexion");
            }
        }
        catch (ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error de conexion " + e.getMessage());
        }
        return currentConnection;
    }
    
        public static void desconexion(){
        try{
            currentConnection.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog (null, "error al desconectra" + e.getMessage());
        }
    }
}
