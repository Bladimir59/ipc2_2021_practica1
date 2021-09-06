/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author bladimir
 */
public class DetalleFactura {
    
    private int codigoFactura;
    private String nombreMueble;
    private int cantidad;

    public DetalleFactura(int codigoFactura, String nombreMueble, int cantidad) {
        this.codigoFactura = codigoFactura;
        this.nombreMueble = nombreMueble;
        this.cantidad = cantidad;
    }

    public DetalleFactura() {
    }
    

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
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
