package DAO;

import Clases.ProductoTienda;
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
public class MuebleTiendaDAO {
    private static Connection cn;
    private static conexion.Conectar inicia;
    //conexion para la base de datos
    public static Connection obtenerConexion(){
        inicia= new Conectar();
        cn = inicia.getConnection();
        return cn;
    }
    
    
    //para mover de fabrica a tienda
    private static final String queryINSERT= "INSERT INTO Mueble_Tienda( Mueble_Nombre_Mueble, Cantidad, precion) VALUES(?,?,?)";
    public void mover(ProductoTienda producto){
        obtenerConexion();
        try {
            PreparedStatement inserta = cn.prepareStatement(queryINSERT);
            inserta.setString(1, producto.getNombre());
            inserta.setInt(2, producto.getCantidad());
            inserta.setDouble(3, producto.getPrecio());
            inserta.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    //para ver los muebles a vender
    private static final String queryVerTodo="SELECT * FROM Mueble_Tienda";
    public List<ProductoTienda> muebles(){
        List<ProductoTienda> listado = new ArrayList<>();
        obtenerConexion();
        PreparedStatement obtener = null;
        ResultSet rs = null;
        try {
            obtener = cn.prepareStatement(queryVerTodo);
            rs = obtener.executeQuery();
            while (rs.next()) {                
                ProductoTienda producto = new ProductoTienda(rs.getInt("idEnTienda"), rs.getString("Mueble_Nombre_Mueble"), rs.getDouble("precion"), rs.getInt("Cantidad"));
                producto.setId(rs.getInt("idEnTienda"));
                producto.setNombre(rs.getString("Mueble_Nombre_Mueble"));
                producto.setCantidad(rs.getInt("Cantidad"));
                producto.setPrecio(rs.getDouble("precion"));
                listado.add(producto);
            }   
        } catch (Exception e) {
        }
        return listado; 
    }
    //para obtener solo un producto dependiendo de el id
    private static final String unMueble = "SELECT * FROM Mueble_Tienda WHERE idEnTienda= ?";  
    public ProductoTienda obtenerProducto(int id){
        obtenerConexion();
        PreparedStatement obtener = null;
        ResultSet rs = null;
        ProductoTienda retorno = null;
        try {
            obtener=cn.prepareStatement(unMueble);
            obtener.setInt(1, id);
            rs=obtener.executeQuery();
            while (rs.next()) {
                retorno=new ProductoTienda(rs.getInt("idEnTienda"), rs.getString("Mueble_Nombre_Mueble"), rs.getDouble("precion"), rs.getInt("Cantidad"));
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return retorno;
    }
}
