/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexion.Conectar;
import java.sql.Connection;
import Clases.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author bladimir
 */
public class UsuarioDAO {
    private static Connection cn;
    private static conexion.Conectar inicia;
    
    //conexion para la base de datos
    public static Connection obtenerConexion(){
        inicia= new Conectar();
        cn = inicia.getConnection();
        return cn;
    }
    //para traer un usuario para el la entrada del login a donde dirigirlo
    public Clases.Usuario tipoUsuario(Usuario Usuario){
        obtenerConexion();
        String query="SELECT * FROM Usuario WHERE Nombre_Usuario =? AND Password =?";
        PreparedStatement obtener=null;
        ResultSet rs=null;
        Usuario recibido = null;
        try {
            obtener=cn.prepareStatement(query);
            obtener.setString(1, Usuario.getNombre());
            obtener.setString(2, Usuario.getPassword());
            rs=obtener.executeQuery();
            recibido=new Usuario(rs.getString("Password"), rs.getInt("Area"), rs.getString("Nombre_Usuario"));           
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        System.out.println(recibido.toString());
        return recibido;
    }
    
}
