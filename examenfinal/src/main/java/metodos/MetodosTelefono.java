
package metodos;
import Entidades.Telefono;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import principal.conexion;

public class MetodosTelefono {
    
     public int guardarTelefono(Telefono pais) {     
        String sql_guardar;
        int numFilas = 0;
        sql_guardar = "INSERT INTO telefono (nombre, imagenbandera) VALUES ('"+ pais.getNombre() + "', '"+ pais.getImagenbandera()+"')";
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
     
     public ArrayList<Telefono> consultarTelefono(String nombre) {
        ArrayList<Telefono> telefonoConsulta = new ArrayList<Telefono>();

        String sql_select = "SELECT * FROM telefono     ";       
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
                telefonoConsulta.add(new Telefono());
                telefonoConsulta.get(counter).setCodigo(tabla.getString(1));
                telefonoConsulta.get(counter).setNombre(tabla.getString(2));               
                counter++;
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        }
        return telefonoConsulta;
    }

    public void modificarTelefono(Telefono telefono) {
        try {
            String sql_modificar = "UPDATE telefono";
            sql_modificar += " set nombre = '" + telefono.getNombre() + "'";
            sql_modificar += " WHERE codigo = '" + telefono.getCodigo() + "'";

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

    public void eliminarTelefono(Telefono telefono) {       
        try {
            String sql_eliminar = "DELETE FROM telefono";
            sql_eliminar += " WHERE codigo = '" + telefono.getCodigo() + "'";

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
