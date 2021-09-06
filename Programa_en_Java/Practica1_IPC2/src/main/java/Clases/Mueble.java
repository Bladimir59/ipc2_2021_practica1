package Clases;

/**
 *
 * @author bladimir
 */
public class Mueble {
    private String nombre;
    private double precio;
    private int cantidad;

    public Mueble(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Mueble() {
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
