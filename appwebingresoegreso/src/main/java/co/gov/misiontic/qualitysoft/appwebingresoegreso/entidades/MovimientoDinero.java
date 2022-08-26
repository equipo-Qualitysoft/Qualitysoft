package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

public class MovimientoDinero {
    private double monto;
    private String concepto;
    private Empleado usuario;

    // Definition of Done
    // Es posible crear una nueva instancia de la clase MovimientoDinero
    public MovimientoDinero(double monto, String concepto, Empleado usuario) {
        this.setMonto(monto);
        this.setConcepto(concepto);
        this.usuario = usuario;
    }

    // Definition of Done
    // Es posible leer el monto del movimiento
    public double getMonto() {
        return monto;
    }

    // Definition of Done
    // Es posible modificar el monto del movimiento
    public void setMonto(double monto) {
        this.monto = monto;
    }

    // Definition of Done
    // Es posible crear montos positivos y negativos
    public void crearMonto(double monto, boolean egreso){
        if (!egreso)
            this.monto += monto;  // Ingreso
        else
            this.monto -= monto;  // Egreso
    }

    // Definition of Done
    // Es posible leer el concepto del movimiento
    public String getConcepto() {
        return concepto;
    }
    // Definition of Done
    // Es posible modificar el concepto del movimiento
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    // Definition of Done
    // Es posible definir que usuario(empleado) fue encargado del registro el movimiento
    public Empleado getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "monto=" + monto +
                ", concepto='" + concepto + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}

