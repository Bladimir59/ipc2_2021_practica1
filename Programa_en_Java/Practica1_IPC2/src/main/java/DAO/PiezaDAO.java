package DAO;

import Clases.Costo;
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
    private static final String nueva=" INSERT INTO Pieza (Nombre_Pieza) VALUES (?) ";
    public void crearPieza (Pieza pieza){
        obtenerConexion();
        try {
            PreparedStatement insertar=cn.prepareStatement(nueva);
            insertar.setString(1, pieza.getNombre());
            insertar.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }        
    }
    //para su costo
    private static final String nuevoCosto="INSERT INTO CostoPieza(Pieza_Nombre_Pieza, Costo ,Cantidad) VALUE (?,?,?)";
    public  void crearCosto (Costo costo){
        obtenerConexion();
        try {
            PreparedStatement insertar=cn.prepareStatement(nuevoCosto);
            insertar.setString(1, costo.getNombre());
            insertar.setDouble(2, costo.getCosto());
            insertar.setInt(3, costo.getCantidad());
            insertar.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace(System.out);
        }
    }
    
    //para la modificacion de los datos de una pieza
    private static  final String modificar="UPDATE CostoPieza SET  Pieza_Nombre_Pieza =?, Costo=?,  Cantidad=? WHERE idCosto=?";
    public void modificarPieza(Costo dato){
        obtenerConexion();
        try {
            PreparedStatement insertar = cn.prepareStatement(modificar);
            insertar.setString(1, dato.getNombre());
            insertar.setDouble(2, dato.getCosto());
            insertar.setInt(3, dato.getCantidad());
            insertar.setInt(4, dato.getId());
            insertar.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    //para ver en la carga de archivo si existe la pieza on el precio
    
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
    //va a servir para la lectura de carga de archivo
    private static final String consulta="SELECT * FROM CostoPieza WHERE (Pieza_Nombre_Pieza  =? AND Costo=?) LIMIT 1";
    public Costo consultaExisteCosto(String nombre, Double precio){
        obtenerConexion();
        PreparedStatement obtener=null;
        ResultSet rs=null;
        Costo retorno=null;
        try {
            obtener=cn.prepareStatement(consulta);
            obtener.setString(1, nombre);
            obtener.setDouble(2, precio);
            rs=obtener.executeQuery();
            while (rs.next()) {                
                retorno=new Costo(rs.getInt("idCosto"), rs.getString("Pieza_Nombre_Pieza"), rs.getDouble("Costo"), rs.getInt("Cantidad"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        
        return retorno;
    }
    
    private static final String consultaPieza="SELECT * FROM Pieza WHERE ( Nombre_Pieza =?) LIMIT 1;";
    public Pieza consultaExistePieza(String nombre){
        obtenerConexion();
        PreparedStatement obtener=null;
        ResultSet rs=null;
        Pieza retorno=null;
        try {
            obtener=cn.prepareStatement(consultaPieza);
            obtener.setString(1, nombre);
            
            rs=obtener.executeQuery();
            while (rs.next()) {                
                retorno=new Pieza(rs.getString("Nombre_Pieza"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        
        return retorno;
    }
    //retorna su codigo
    private static final String consulta1="SELECT * FROM Pieza WHERE Nombre_Pieza=? LIMIT 1";
    public Pieza consultacodigo(String nombre){
        obtenerConexion();
        PreparedStatement obtener=null;
        ResultSet rs=null;
        Pieza retorno=null;
        System.out.println(""+nombre+" desde consulta existe");
        try {
            obtener=cn.prepareStatement(consulta1);
            obtener.setString(1, nombre);
            rs=obtener.executeQuery();
            while (rs.next()) {                
                retorno=new Pieza(rs.getString("Nombre_Pieza"),rs.getDouble("Costo_Pieza"), rs.getInt("Cantidad_Pieza"), rs.getInt("idPieza"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        
        return retorno;
    }
    
}
