
package metodos;
import Entidades.Modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import principal.conexion;

public class MetodosModelo {
    
     public int guardarModelo(Modelo pais) {     
        String sql_guardar;
        int numFilas = 0;
        sql_guardar = "INSERT INTO modelo (nombre) VALUES ('"+ pais.getNombre() + "')";
        try {
            conexion cc=new conexion();
            Connection conn=cc.conexionFunc();
            Statement sentencia = conn.createStatement();
            System.out.println("SQL: " + sql_guardar);
            numFilas = sentencia.executeUpdate(sql_guardar);
            return numFilas;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        }

        return -1;
    }
     
     public ArrayList<Modelo> consultarModelo(String nombre) {
        ArrayList<Modelo> metodoConsulta = new ArrayList<Modelo>();

        String sql_select = "SELECT * FROM modelo     ";       
         if (!nombre.isEmpty()) {
            sql_select += "WHERE ";
        }
        if (!nombre.isEmpty()) {
            sql_select += "nombre LIKE '%" + nombre + "%' AND ";
        }
        
     

        sql_select = sql_select.substring(0, sql_select.length() - 5);

        try {
            conexion cc=new conexion();
            Connection conn=cc.conexionFunc();
            System.out.println("SQL Consulta: " + sql_select);
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            int counter = 0;
            while (tabla.next()) {
                metodoConsulta.add(new Modelo());
                metodoConsulta.get(counter).setCodigo(tabla.getString(1));
                metodoConsulta.get(counter).setNombre(tabla.getString(2));               
                counter++;
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        }
        return metodoConsulta;
    }

    public void modificarModelo(Modelo modelo) {
        try {
            String sql_modificar = "UPDATE modelo";
            sql_modificar += " set nombre = '" + modelo.getNombre() + "'";
            sql_modificar += " WHERE codigo = '" + modelo.getCodigo() + "'";

            conexion cc=new conexion();
            Connection conn=cc.conexionFunc();
            Statement sentencia = conn.createStatement();
            System.out.println("SQL: " + sql_modificar);
            sentencia.executeUpdate(sql_modificar);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        }
    }

    public void eliminarModelo(Modelo modelo) {       
        try {
            String sql_eliminar = "DELETE FROM modelo";
            sql_eliminar += " WHERE codigo = '" + modelo.getCodigo() + "'";

            conexion cc=new conexion();
            Connection conn=cc.conexionFunc();
            Statement sentencia = conn.createStatement();
            System.out.println("SQL: " + sql_eliminar);
            sentencia.executeUpdate(sql_eliminar);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        }
    }
}
