package DAO;

import Clases.Mueble;
import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    //listado de muebles
    public  ArrayList<Mueble> obtenerListaMueble(){
        ArrayList<Mueble> mueble=new ArrayList<>();
        obtenerConexion();
        PreparedStatement pat=null;
        ResultSet rs = null;
        try {
            String Query= "SELECT * FROM Mueble"; 
            pat =cn.prepareStatement(Query);
            rs = pat.executeQuery();
            while (rs.next()) {                
                mueble.add(new Mueble(rs.getString("Nombre_Mueble"), rs.getDouble("Costo_Mueble")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return mueble;
    }
    
    
}
