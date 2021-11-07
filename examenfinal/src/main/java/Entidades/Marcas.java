package Entidades;

public class Marcas {
    private String codigo;
    private String nombre;


    public Marcas(){
    }

    public Marcas(String nombre) {
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
