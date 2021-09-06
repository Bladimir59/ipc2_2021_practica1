/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Clases.EnsamblePieza;
import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bladimir
 */
public class EnsamblePiezasDAO {
    
    private static Connection cn;
    private static conexion.Conectar inicia;
    //conexion para la base de datos
    public static Connection obtenerConexion(){
        inicia= new Conectar();
        cn = inicia.getConnection();
        return cn;
    }
    //llenar los datos de ensamble pieza
    private static final String nueva=" INSERT INTO Ensamble_Pieza (Mueble_Nombre_Mueble, Pieza_Nombre_Pieza , cantidad) VALUES (?,?,?) ";
    public void nuevoEnsamblePieza (EnsamblePieza dato){
        obtenerConexion();
        try {
            PreparedStatement insertar=cn.prepareStatement(nueva);
            insertar.setString(1, dato.getNombreMueble());
            insertar.setString(2, dato.getNombrePieza());
            insertar.setInt(3, dato.getCantidad());
            insertar.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }        
    }
    
}
