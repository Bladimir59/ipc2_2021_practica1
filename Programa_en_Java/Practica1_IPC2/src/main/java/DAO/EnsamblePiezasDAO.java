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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    //para ver todo los tipos de ensamble y el usuario decida cual usar
    private static final String querytodo="SELECT * FROM Ensamble_Pieza";
    public List<EnsamblePieza> verEnsambles(){
        List<EnsamblePieza> listado = new ArrayList<>();
        obtenerConexion();
        PreparedStatement obtener = null;
        ResultSet rs = null;
        try {
            obtener=cn.prepareStatement(querytodo);
            rs=obtener.executeQuery();
            while (rs.next()) {                
                EnsamblePieza nuevo = new EnsamblePieza(rs.getString("Mueble_Nombre_Mueble"), rs.getString("Pieza_Nombre_Pieza"), rs.getInt("cantidad"));
                nuevo.setNombreMueble(rs.getString("Mueble_Nombre_Mueble"));
                nuevo.setNombrePieza(rs.getString("Pieza_Nombre_Pieza"));
                nuevo.setCantidad(rs.getInt("cantidad"));
                listado.add(nuevo);
            }
        } catch (Exception e) {
        }
        
        return listado;
    }
    
}
