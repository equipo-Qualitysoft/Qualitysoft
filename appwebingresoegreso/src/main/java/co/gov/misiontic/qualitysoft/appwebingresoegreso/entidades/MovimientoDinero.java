package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import java.time.LocalDate;

public class MovimientoDinero {
    private long idMovimiento;
    private String concepto;
    private float monto;
    private Empleado usuario;
    private Empresa empresa;
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizacion;

    public MovimientoDinero(String concepto, float monto, Empleado usuario, Empresa empresa) {
        this.concepto = concepto;
        this.monto = monto;
        this.usuario = usuario;
        this.empresa = empresa;
        this.fechaCreacion = LocalDate.now();;
    }

    public MovimientoDinero(String concepto, float monto) {
        this.concepto = concepto;
        this.monto = monto;
        this.usuario = getUsuario();
        this.empresa = getEmpresa();
        this.fechaCreacion = getFechaCreacion();;
        this.fechaActualizacion = LocalDate.now();
    }

    public void crearMonto(float monto){
        if (monto > 0)
            new MovimientoDinero("INGRESO", monto);
        else if(monto < 0)
            new MovimientoDinero("EGRESO", monto);
    }

    public long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado empleado) {
        this.usuario = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
        return "MovimientoDinero{" +
                "id=" + idMovimiento +
                ", concepto='" + concepto + '\'' +
                ", monto=" + monto +
                ", usuario=" + usuario +
                ", empresa=" + empresa +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizacion=" + fechaActualizacion +
                '}';
    }
}

