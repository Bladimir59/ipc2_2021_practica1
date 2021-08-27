/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Clases.EnsambleMueble;
import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bladimir
 */
public class EnsambleMuebleDAO {
    private static Connection cn;
    private static conexion.Conectar inicia;
    //conexion para la base de datos
    public static Connection obtenerConexion(){
        inicia= new Conectar();
        cn = inicia.getConnection();
        return cn;
    }
    //llenar los datos de ensamble pieza
    private static final String nueva=" INSERT INTO  Ensamble_Mueble(Mueble_Nombre_Mueble, Usuario_Nombre_Usuario , Usuario_Nombre_Usuario , Estado) VALUES (?,?,?,?) ";
    public void nuevoEnsambleMueble (EnsambleMueble dato){
        obtenerConexion();
        try {
            PreparedStatement insertar=cn.prepareStatement(nueva);
            insertar.setString(1, dato.getNombreMueble());
            insertar.setString(2, dato.getNombreUsuario());
            insertar.setDate(3, dato.getFecha());
            insertar.setBoolean(4, true);
            insertar.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }        
    }
}
