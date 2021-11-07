package Controladores;
import metodos.MetodosTelefono;
import Entidades.Telefono;
import java.util.ArrayList;
import java.util.Arrays;
public class ControladorTelefono {
    MetodosTelefono metodosTelefono;
    Telefono telefonoSeleccionado;
    ArrayList<Telefono> ultimaConsulta;
    public ControladorTelefono() {
       metodosTelefono = new MetodosTelefono();
    }
    
    public String insertarTelefono(String nombre, String imagenbandera) {
        //<editor-fold defaultstate="collapsed" desc="insertarEstudiante()">
        if (!nombre.isEmpty()) {
            Telefono telefono = new Telefono();
            telefono.setNombre(nombre);
            telefono.setImagenbandera(imagenbandera);
            if (metodosTelefono.guardarTelefono(telefono) == -1) {
                return "No es posible registrar el telefono:\n"
                        + "(1) Verifique la conexion con la base de datos no tenga problemas.\n"
                        + "(2) O que el telefono no se encuentre ya registrado";
            }
            System.out.println("Se insertó un nuevo telefono");
            return "OK";
        } else {
        }
        return "Es necesario ingresar la informacion de todos los campos";
        //</editor-fold>
    }
    
    public Object[][] consultarTelefono(String nombre) {        
        ultimaConsulta = metodosTelefono.consultarTelefono(nombre);
        Object resultado[][] = new Object[ultimaConsulta.size()][2];
        for (int i = 0; i < resultado.length; i++) {         
         resultado[i][0] = ultimaConsulta.get(i).getCodigo().toString();
         resultado[i][1] = ultimaConsulta.get(i).getNombre().toString();
        }
        return resultado;       
    }
    
     public String[] seleccionarTelefono(int seleccionado) {
        
        String telefono[] = new String[2];
        telefonoSeleccionado = ultimaConsulta.get(seleccionado);
        
        telefono[0] = telefonoSeleccionado.getCodigo();
        telefono[1] = telefonoSeleccionado.getNombre();
        
        return telefono;

    }

    public String actualizarTelefono(String nombre) {
        if (!nombre.isEmpty()) {
            
            telefonoSeleccionado.setNombre(nombre);         
            metodosTelefono.modificarTelefono(telefonoSeleccionado);
            
            return "OK";
        } else {
            return "Es necesario ingresar la informacion de todos los campos";
        }
    }
    
    public void eliminarTelefono() {
        metodosTelefono.eliminarTelefono(telefonoSeleccionado);
    }
}
