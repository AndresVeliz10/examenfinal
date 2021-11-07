
package metodos;
import Entidades.Marcas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import principal.conexion;

public class MetodosMarcas {
    
     public int guardarMarca(Marcas marca) {     
        String sql_guardar;
        int numFilas = 0;
        sql_guardar = "INSERT INTO marcas (nombre) VALUES ('"+ marca.getNombre() + "')";
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
     
     public ArrayList<Marcas> consultarMarca(String nombre) {
        ArrayList<Marcas> estudiantesConsulta = new ArrayList<Marcas>();

        String sql_select = "SELECT * FROM marcas     ";       
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
                estudiantesConsulta.add(new Marcas());
                estudiantesConsulta.get(counter).setCodigo(tabla.getString(1));
                estudiantesConsulta.get(counter).setNombre(tabla.getString(2));               
                counter++;
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        }
        return estudiantesConsulta;
    }

    public void modificarMarca(Marcas pais) {
        try {
            String sql_modificar = "UPDATE marcas";
            sql_modificar += " set nombre = '" + pais.getNombre() + "'";
            sql_modificar += " WHERE codigo = '" + pais.getCodigo() + "'";

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

    public void eliminarMarca(Marcas Paises) {       
        try {
            String sql_eliminar = "DELETE FROM marcas";
            sql_eliminar += " WHERE codigo = '" + Paises.getCodigo() + "'";

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
