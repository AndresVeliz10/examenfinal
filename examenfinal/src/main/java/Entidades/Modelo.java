package Entidades;

public class Modelo {
    private String codigo;
    private String nombre;


    public Modelo(){
    }

    public Modelo(String nombre) {
        this.nombre = nombre;
      
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   
}
