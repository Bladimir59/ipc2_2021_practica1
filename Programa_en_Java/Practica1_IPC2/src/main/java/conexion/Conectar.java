package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author bladimir
 */
public class Conectar {
     public Connection conn = null;
    
    //variables que son datos de la base de datos
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "admin";
    private static final String url = "jdbc:mysql://localhost:3306/Practica1_IPC2";
    
    //metodo encargado de ingresar a la base de datos
    public Conectar(){
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("Conexion establecida");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al conectar "+ex);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    //metodo encargado de slair de la base de datos
    public void Desconectar(){
        conn = null;
        if(conn == null){
            System.out.println("Conexion establecida");
        }
    }
    
}
