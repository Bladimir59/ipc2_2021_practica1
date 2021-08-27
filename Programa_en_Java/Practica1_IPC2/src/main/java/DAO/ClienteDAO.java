/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Clases.Cliente;
import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bladimir
 */
public class ClienteDAO {
    private static Connection cn;
    private static conexion.Conectar inicia;
    //conexion para la base de datos
    public static Connection obtenerConexion(){
        inicia= new Conectar();
        cn = inicia.getConnection();
        return cn;
    }
    //INSERTAR NUEVO MUEBLE
    private static final String nueva="INSERT INTO Cliente (NIT , Nombre_Cliente , Direccion , Municipio , Departamento) VALUES (?,?,?,?,?)";
    public void crearCliente (Cliente dato){
        obtenerConexion();
        try {
            PreparedStatement insertar=cn.prepareStatement(nueva);
            insertar.setString(1, dato.getNit());
            insertar.setString(2, dato.getNombre());
            insertar.setString(3, dato.getDireccion());
            insertar.setString(4, dato.getMunicipio());
            insertar.setString(5, dato.getDepartamento());
            insertar.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }        
    }
}
