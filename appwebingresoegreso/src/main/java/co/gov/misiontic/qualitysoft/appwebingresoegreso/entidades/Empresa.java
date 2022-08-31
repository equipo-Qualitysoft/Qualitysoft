package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import java.time.LocalDate;
import java.util.Arrays;

public class Empresa {
    //atributos
    private long idEmpresa;
    private String nombre;
    private String nit;
    private String telefono;
    private String direccion;
    private Empleado usuarios[];
    private MovimientoDinero movimientos[];
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizaion;

    public Empresa(String nombre, String nit, String telefono, String direccion, Empleado[] empleados, MovimientoDinero[] movimientos) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuarios = empleados;
        this.movimientos = movimientos;
        this.fechaCreacion = LocalDate.now();;
    }

    public long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Empleado[] getUsuario() {
        return usuarios;
    }

    public void setUsuario(Empleado[] empleados) {
        this.usuarios = empleados;
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

    public LocalDate getFechaActualizaion() {
        return fechaActualizaion;
    }

    public void setFechaActualizaion(LocalDate fechaActualizaion) {
        this.fechaActualizaion = fechaActualizaion;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + idEmpresa +
                ", nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", usuario=" + Arrays.toString(usuarios) +
                ", movimientos=" + Arrays.toString(movimientos) +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizaion=" + fechaActualizaion +
                '}';
    }
}