package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import java.time.LocalDate;
import java.util.Arrays;

public class Empleado {
    private long idEmpleado;
    private String nombre;
    private String correo;
    private Perfil perfil;
    private Rol rol;
    private Empresa empresa;
    private MovimientoDinero movimientos[];
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizacion;

    public Empleado(String nombre, String correo, Perfil perfil, Rol rol, Empresa empresa, MovimientoDinero[] movimientos) {
        this.nombre = nombre;
        this.correo = correo;
        this.perfil = perfil;
        this.rol = rol;
        this.empresa = empresa;
        this.movimientos = movimientos;
        this.fechaCreacion = LocalDate.now();
    }
    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public MovimientoDinero[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(MovimientoDinero[] movimientos) {
        this.movimientos = movimientos;
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
        return "Empleado{" +
                "id=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", perfil=" + perfil +
                ", rol=" + rol +
                ", empresa=" + empresa +
                ", movimientos=" + Arrays.toString(movimientos) +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizacion=" + fechaActualizacion +
                '}';
    }
}
