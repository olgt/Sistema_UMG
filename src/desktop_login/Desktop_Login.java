/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktop_login;
import clases_de_sistema.*;

/**
 *
 * @author olgt1
 */
public class Desktop_Login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ConnectionOracleDeprecated connection = new ConnectionOracleDeprecated();
        connection.LocalDatabaseConnection();
        
        //Conexion con fines ilustrativos (Falta agregar consultas
        //para registro de datos
        */
        //Registro_Universidad registro = new Registro_Universidad();
        
        Estudiante estudiantePrueba = new Estudiante("1234","1234", "Juan", "1234", "juan@miumg.com", "1234");
        
        
        Login loginScreen = new Login();
        loginScreen.setVisible(true);
    }
}
