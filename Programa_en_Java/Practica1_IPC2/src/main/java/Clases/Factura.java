/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;

/**
 *
 * @author bladimir
 */
public class Factura {
    private Date fecha;
    private int total;
    private String usuario;
    private String cliente;

    
    public Factura(Date fecha, int total, String usuario, String cliente) {
        this.fecha = fecha;
        this.total = total;
        this.usuario = usuario;
        this.cliente = cliente;
    }

    public Factura() {
    }

    
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
}
