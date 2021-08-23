package Clases;

/**
 *
 * @author bladimir
 */
public class Usuario extends Persona{
    
    public Usuario(String nombre) {
        super(nombre);
    }
    private String password;
    private int divicion;
    private boolean activo;
//para traer al Usuario
    public Usuario(String password, String nombre) {
        super(nombre);
        this.password = password;
    }
//para ver los datos

    public Usuario(String password, int divicion, String nombre) {
        super(nombre);
        this.password = password;
        this.divicion = divicion;
    }
    
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDivicion() {
        return divicion;
    }

    public void setDivicion(int divicion) {
        this.divicion = divicion;
    }

    
    
}
