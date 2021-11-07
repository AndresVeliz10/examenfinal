package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class conexion {
    
    public static void main(String args[]){        
    }
    
    Connection conectar = null;
    
    public Connection conexionFunc(){
        String url = "jdbc:mysql://localhost:3306/ExamenFinalProgra2B-2";
        String usuario = "root";
        String contrasenia = "";
        
         try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar= DriverManager.getConnection(url, usuario, contrasenia); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return conectar;
    }        
    
}
