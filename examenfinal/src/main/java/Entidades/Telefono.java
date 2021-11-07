package Entidades;

public class Telefono {
    private String codigo;

   
    private String nombre;
    private String imagenbandera;

    public Telefono(){
    }

    public Telefono(String nombre, String imagenbandera) {
        this.nombre = nombre;
        this.imagenbandera = imagenbandera;
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
    
    public String getImagenbandera() {
        return imagenbandera;
    }

    public void setImagenbandera(String imagenbandera) {
        this.imagenbandera = imagenbandera;
    }
}
