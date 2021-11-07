package Controladores;
import metodos.MetodosModelo;
import Entidades.Modelo;
import java.util.ArrayList;
public class ControladorModelo {
    MetodosModelo metodosModelo;
    Modelo modeloSeleccionado;
    ArrayList<Modelo> ultimaConsulta;
    public ControladorModelo(){
       metodosModelo = new MetodosModelo();
    }
    
    public String insertarModelo(String nombre) {
        if (!nombre.isEmpty()) {
            Modelo modelo = new Modelo();
            modelo.setNombre(nombre);         
            if (metodosModelo.guardarModelo(modelo) == -1) {
                return "No es posible registrar el Modelo:\n"
                        + "(1) Verifique la conexion con la base de datos no tenga problemas.\n"
                        + "(2) O que el Modelo no se encuentre ya registrado";
            }
            System.out.println("Se insertó un nuevo Modelo");
            return "OK";
        } else {
        }
        return "Es necesario ingresar la informacion de todos los campos";
        //</editor-fold>
    }
    
    public Object[][] consultarModelo(String nombre) {        
        ultimaConsulta = metodosModelo.consultarModelo(nombre);
        Object resultado[][] = new Object[ultimaConsulta.size()][2];
        for (int i = 0; i < resultado.length; i++) {         
         resultado[i][0] = ultimaConsulta.get(i).getCodigo().toString();
         resultado[i][1] = ultimaConsulta.get(i).getNombre().toString();
        }
        return resultado;       
    }
    
     public String[] seleccionarModelo(int seleccionado) {
        
        String modelo[] = new String[2];
        modeloSeleccionado = ultimaConsulta.get(seleccionado);
        
        modelo[0] = modeloSeleccionado.getCodigo();
        modelo[1] = modeloSeleccionado.getNombre();
        
        return modelo;

    }

    public String actualizarModelo(String nombre) {
        if (!nombre.isEmpty()) {
            
            modeloSeleccionado.setNombre(nombre);         
            metodosModelo.modificarModelo(modeloSeleccionado);
            
            return "OK";
        } else {
            return "Es necesario ingresar la informacion de todos los campos";
        }
    }
    
    public void eliminarModelo() {
        metodosModelo.eliminarModelo(modeloSeleccionado);
    }
}
