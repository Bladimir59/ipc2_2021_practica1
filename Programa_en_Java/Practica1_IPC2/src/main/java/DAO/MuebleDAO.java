package DAO;

import Clases.Mueble;
import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bladimir
 */
public class MuebleDAO {
    private static Connection cn;
    private static conexion.Conectar inicia;
    //conexion para la base de datos
    public static Connection obtenerConexion(){
        inicia= new Conectar();
        cn = inicia.getConnection();
        return cn;
    }
    //INSERTAR NUEVO MUEBLE
    private static final String nueva="INSERT INTO Mueble (Nombre_Mueble , Costo_Mueble) VALUES (?,?)";
    public void crearMueble (Mueble pieza){
        obtenerConexion();
        try {
            PreparedStatement insertar=cn.prepareStatement(nueva);
            insertar.setString(1, pieza.getNombre());
            insertar.setDouble(2, pieza.getPrecio());
            insertar.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }        
    }
    //consulta si existe del mismo precio 
    
}
