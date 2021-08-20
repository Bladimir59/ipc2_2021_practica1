package manejador;

import conexion.Conectar;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author bladimir
 */
public class Verificar {
    private static Connection cn;
    private static conexion.Conectar login;
    private static final String VERIFICAR= "SELECT *FROM Usuario";
    private static ResultSet rs=null;
    //conexion para la base de datos
    public static Connection obtenerConexion(){
        login= new Conectar();
        cn = login.getConnection();
        return cn;
    }
     public static boolean siExiste()throws SQLException, IOException{
        boolean hay=false;
        obtenerConexion();
        PreparedStatement obtener=null;
        obtener=cn.prepareStatement(VERIFICAR);
        rs=obtener.executeQuery(VERIFICAR);
        hay=rs.next();
        return hay;
    }
    
}
