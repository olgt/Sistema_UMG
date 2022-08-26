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
public class Conexion {
 
    private static Connection conn = null;
    private static String login = "UMG";
    private static  String clave = "123456";
    private static String url= "jdbc:oracle:thin:@localhost:1521:xe";
    
    
    public Connection getConnection(String p_login, String p_clave) throws SQLException{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn= DriverManager.getConnection(url, p_login, p_clave);
            conn.setAutoCommit(false);
            if(conn != null){
                JOptionPane.showMessageDialog (null, "Conexion exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Error de Conexion");
            }
        }
        catch (ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error de conexion " + e.getMessage());
        }
        return conn;
    }
    
        public void desconexion(){
        try{
            conn.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog (null, "error al desconectra" + e.getMessage());
        }
    }
}
