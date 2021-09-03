package Clases;

/**
 *
 * @author bladimir
 */
public class EnsamblePieza {
    private String nombrePieza;
    private String nombreMueble;
    private int cantidad;
    private int codigoPieza;

    public EnsamblePieza(String nombrePieza, String nombreMueble, int cantidad) {
        this.nombrePieza = nombrePieza;
        this.nombreMueble = nombreMueble;
        this.cantidad = cantidad;
    }

    public EnsamblePieza(String nombreMueble, int cantidad, int codigoPieza) {
        this.nombreMueble = nombreMueble;
        this.cantidad = cantidad;
        this.codigoPieza = codigoPieza;
    }

    
    public int getCodigoPieza() {
        return codigoPieza;
    }

    public void setCodigoPieza(int codigoPieza) {
        this.codigoPieza = codigoPieza;
    }

    
    public String getNombrePieza() {
        return nombrePieza;
    }

    public void setNombrePieza(String nombrePieza) {
        this.nombrePieza = nombrePieza;
    }

    public String getNombreMueble() {
        return nombreMueble;
    }

    public void setNombreMueble(String nombreMueble) {
        this.nombreMueble = nombreMueble;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
