package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity @Data
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "clave")
    private String clave;
    @Column(name = "rol_id")
    @Enumerated(EnumType.ORDINAL)
    private Rol rol;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    @OneToMany
    @JoinColumn(name = "Movimiento_id")
    private List<MovimientoDinero> movimientos;
    @Column(name = "fecha")
    private LocalDate fecha;
    public Usuario() {
    }
    public Usuario(String nombre, String imagen, String correo, String telefono, String clave, Rol rol, Empresa empresa, List<MovimientoDinero> movimientos) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.correo = correo;
        this.telefono = telefono;
        this.clave = clave;
        this.rol = rol;
        this.empresa = empresa;
        this.movimientos = movimientos;
        this.fecha = LocalDate.now();
    }
}