package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import java.time.LocalDate;

public class Perfil {
    private String idPerfil;
    private String imagen;
    private String telefono;
    private Empleado usuario;

    private String clave;
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizacion;

    public Perfil(String idPerfil, String imagen, String telefono, Empleado usuario, String clave) {
        this.idPerfil = idPerfil;
        this.imagen = imagen;
        this.telefono = telefono;
        this.usuario = usuario;
        this.clave = clave;
        this.fechaCreacion = LocalDate.now();;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado empleado) {
        this.usuario = empleado;
    }

    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id='" + idPerfil + '\'' +
                ", imagen='" + imagen + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuario=" + usuario +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizacion=" + fechaActualizacion +
                '}';
    }
}
