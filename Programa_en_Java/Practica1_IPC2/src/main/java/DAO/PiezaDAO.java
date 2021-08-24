package DAO;

import conexion.Conectar;
import java.sql.Connection;
import Clases.Pieza;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bladimir
 */
public class PiezaDAO {
    private static Connection cn;
    private static conexion.Conectar inicia;
    private static final String nueva=" INSERT INTO Pieza (Nombre_Pieza, Costo_Pieza, Cantidad_Pieza) VALUES (?,?,?) ";
    //conexion para la base de datos
    public static Connection obtenerConexion(){
        inicia= new Conectar();
        cn = inicia.getConnection();
        return cn;
    }
    
    //para crear nuevas piezas
    public void crearPieza (Pieza pieza){
        obtenerConexion();
        try {
            PreparedStatement insertar=cn.prepareStatement(nueva);
            insertar.setString(1, pieza.getNombre());
            insertar.setDouble(2, pieza.getPrecio());
            insertar.setInt(3, pieza.getCantidad());
            insertar.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }        
    }
    //para la modificacion de los datos de una pieza
    
    //para la iliminacion de una pieza
    
}
