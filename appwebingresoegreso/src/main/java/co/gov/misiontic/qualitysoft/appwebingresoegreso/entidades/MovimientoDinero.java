package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.EmpresaServicio;
import co.gov.misiontic.qualitysoft.appwebingresoegreso.servicios.UsuarioService;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "movimientos")

public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMovimiento;
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "monto")
    private float monto;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Articulo articulo;

    @ManyToOne
    @JoinColumn(name = "cp_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ClienteProveedor clienteProveedor;

    public MovimientoDinero() {
    }
    public MovimientoDinero(String concepto, float monto, Usuario usuario) {
        this.concepto = concepto;
        this.monto = monto;
        this.usuario = usuario;
        this.empresa = usuario.getEmpresa();// <== Implementar --> guardar la empresa a la que pertenece el usuario que crea el movimiento
        this.fecha = LocalDate.now();
    }
}