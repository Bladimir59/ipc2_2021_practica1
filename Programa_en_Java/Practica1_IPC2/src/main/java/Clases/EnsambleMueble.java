package Clases;

import java.sql.Date;

/**
 *
 * @author bladimir
 */
public class EnsambleMueble {
    private String nombreMueble;
    private String nombreUsuario;
    private Date fecha;
    private Boolean estado;

    public EnsambleMueble(String nombreMueble, String nombreUsuario, Date fecha, Boolean estado) {
        this.nombreMueble = nombreMueble;
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.estado = estado;
    }

    public EnsambleMueble(String nombreMueble, String nombreUsuario, Date fecha) {
        this.nombreMueble = nombreMueble;
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
    }

    public EnsambleMueble() {
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getNombreMueble() {
        return nombreMueble;
    }

    public void setNombreMueble(String nombreMueble) {
        this.nombreMueble = nombreMueble;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "EnsambleMueble{" + "nombreMueble=" + nombreMueble + ", nombreUsuario=" + nombreUsuario + ", fecha=" + fecha + '}';
    }
    
    
}
