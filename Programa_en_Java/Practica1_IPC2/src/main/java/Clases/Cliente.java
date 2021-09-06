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
public class Cliente extends Persona{

    public Cliente() {
    }
    
    
    //datos nuevos del cliente
    private String nit;
    private String direccion;
    private String municipio;
    private String departamento;

    public Cliente(String nit, String direccion, String municipio, String departamento, String nombre) {
        super(nombre);
        this.nit = nit;
        this.direccion = direccion;
        this.municipio = municipio;
        this.departamento = departamento;
    }

    public Cliente(String nit, String direccion, String nombre) {
        super(nombre);
        this.nit = nit;
        this.direccion = direccion;
    }
    

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
        
}
