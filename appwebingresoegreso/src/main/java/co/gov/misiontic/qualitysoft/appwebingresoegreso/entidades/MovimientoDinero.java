package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
@Table(name="movimientos")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_movimiento")
    private Long idMovimiento;
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "monto")
    private float monto;
    @ManyToOne (optional = false)
    @JoinColumn(name = "usuario")
    private Usuario usuario;
    @Column(name = "fecha")
    private LocalDate fecha;
    public MovimientoDinero() {
    }
    public MovimientoDinero(String concepto, float monto, Usuario usuario) {
        this.concepto = concepto;
        this.monto = monto;
        this.usuario = usuario;
        this.fecha = LocalDate.now();
    }
    public Empresa getEmpresa() {
        return usuario.getEmpresa();
    }

}