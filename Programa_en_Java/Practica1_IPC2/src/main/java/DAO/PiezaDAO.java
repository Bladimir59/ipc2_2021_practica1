package DAO;

import conexion.Conectar;
import java.sql.Connection;
import Clases.Pieza;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bladimir
 */
public class PiezaDAO {
    private static Connection cn;
    private static conexion.Conectar inicia;
    //conexion para la base de datos
    public static Connection obtenerConexion(){
        inicia= new Conectar();
        cn = inicia.getConnection();
        return cn;
    }
    
    //para crear nuevas piezas
    private static final String nueva=" INSERT INTO Pieza (Nombre_Pieza, Costo_Pieza, Cantidad_Pieza) VALUES (?,?,?) ";
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
    private static  final String modificar="UPDATE Pieza SET Nombre_Pieza =?, Costo_Pieza=?,  Cantidad_Pieza=? WHERE idPieza=?";
    public void modificarPieza(Pieza pieza){
        obtenerConexion();
        try {
            PreparedStatement insertar = cn.prepareStatement(modificar);
            insertar.setString(1, pieza.getNombre());
            insertar.setDouble(2, pieza.getPrecio());
            insertar.setInt(3, pieza.getCantidad());
            insertar.setInt(4, pieza.getId());
            insertar.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    //para la iliminacion de una pieza
    private static  final String Delete="DELETE FROM Pieza WHERE idPieza =?;";
    public void eliminarPieza(int codigo){
        obtenerConexion();
        try {
            PreparedStatement insertar = cn.prepareStatement(Delete);
            insertar.setInt(1, codigo);
            insertar.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    //PARA VER TODO LOS ELEMENTOS DE LA TABLA
    private static final String query="SELECT * FROM Pieza";
    public List<Pieza> datos(){
        List<Pieza> listado=new ArrayList<>();
        obtenerConexion();
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            obtener=cn.prepareStatement(query);
            rs=obtener.executeQuery();
            while (rs.next()) {                
                Pieza lista=new Pieza(rs.getString("Nombre_Pieza"), rs.getDouble("Costo_Pieza"), rs.getInt("Cantidad_Pieza"), rs.getInt("idPieza"));
                lista.setId(rs.getInt("idPieza"));
                lista.setNombre(rs.getString("Nombre_Pieza"));
                lista.setPrecio(rs.getDouble("Costo_Pieza"));
                lista.setCantidad(rs.getInt("Cantidad_Pieza"));
                listado.add(lista);
            }
        } catch (Exception e) {
        }
        return listado;
    }
    
}
