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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    private static final String nueva="INSERT INTO  Ensamble_Mueble( Usuario_Nombre_Usuario , Mueble_Nombre_Mueble , Fecha_Ensamble , Estado) "
            + "VALUES (?,?,?,?)";
    public void nuevoEnsambleMueble (EnsambleMueble dato){
        System.out.println(""+dato.toString());
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
    private static final String VerEnFabrica="SELECT * FROM Ensamble_Mueble WHERE Estado = TRUE";
    public List<EnsambleMueble> verEstado(){
        List<EnsambleMueble> listado = new ArrayList<>();
        obtenerConexion();
        PreparedStatement obtener=null;
        ResultSet rs = null;
        try {
            obtener=cn.prepareStatement(VerEnFabrica);
            rs=obtener.executeQuery();
            while (rs.next()) {                
                EnsambleMueble lista = new EnsambleMueble(rs.getString("Mueble_Nombre_Mueble"), rs.getString("Usuario_Nombre_Usuario"),rs.getDate("Fecha_Ensamble"), rs.getBoolean("Estado"));
                lista.setNombreMueble(rs.getString("Mueble_Nombre_Mueble"));
                lista.setNombreUsuario(rs.getString("Usuario_Nombre_Usuario"));
                lista.setFecha(rs.getDate("Fecha_Ensamble"));
                lista.setEstado(rs.getBoolean("Estado"));
                listado.add(lista);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listado;
    }
}
