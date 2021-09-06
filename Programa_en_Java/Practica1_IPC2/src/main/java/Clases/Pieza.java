package Clases;

/**
 *
 * @author bladimir
 */
public class Pieza {
    private String nombre;
    private Double precio;
    private int cantidad;
    private int id;

    public Pieza(String nombre, Double precio, int cantidad, int id) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id = id;
    }

    public Pieza() {
    }

    public Pieza(String nombre) {
        this.nombre = nombre;
    }
    

    public Pieza(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Pieza(String nombre, Double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pieza{" + "nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", id=" + id + '}';
    }
    
    
}
