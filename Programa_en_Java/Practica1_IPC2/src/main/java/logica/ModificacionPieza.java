/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Pieza;
import DAO.PiezaDAO;

/**
 *
 * @author bladimir
 */
public class ModificacionPieza {
    private String nombre;
    private double precio;
    private int cantidad;
    private int codigo;
    
    public void define(String dato){
        if (dato.equals("crear")){
            crearPieza();
        }else if (dato.equals("modificar")){
            modificarPieza();
        }else if (dato.equals("eliminar")){
            eliminarPieza();
        }
    }
    //invoca a los metodos que insertan una pieza
    public void crearPieza(){
        DAO.PiezaDAO nuevo = new PiezaDAO();
        Pieza llenar = new Pieza(nombre, precio, cantidad);
        nuevo.crearPieza(llenar);
    }
    //para modificar los datos de las puizas en la base de datos
    public void modificarPieza(){
        DAO.PiezaDAO modificar = new PiezaDAO();
        Pieza datos = new Pieza(nombre, precio, cantidad, codigo);
        modificar.modificarPieza(datos);
    }
    //metodo para eliminar la pieza
    public void eliminarPieza(){
        DAO.PiezaDAO eliminar = new PiezaDAO();
        eliminar.eliminarPieza(codigo);
    }
    
//para acceder a los elementos
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
