package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.Util.EnumRol;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Setter @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Setter @Getter
    @Column(name = "nombre")
    private String nombre;
    @Setter @Getter
    @Column(name = "imagen")
    private String imagen;
    @Setter @Getter
    @Column(name = "correo")
    private String correo;
    @Setter @Getter
    @Column(name = "telefono")
    private String telefono;
    @Setter @Getter
    @Column(name = "clave")
    private String clave;
    @Setter @Getter
    //@ManyToOne
    @Column(name = "rol", nullable = false)
    @Enumerated(value=EnumType.STRING)
    private EnumRol rol;
    @Setter @Getter
    @ManyToOne(optional = false)
    @JoinColumn(name = "empresa")
    private Empresa empresa;
    @OneToMany
    @JoinColumn(name = "movimientos")
    private List<MovimientoDinero> movimientos;
    @Setter @Getter
    @Column(name = "fecha")
    private LocalDate fecha;
    public Usuario() {
    }
    public Usuario(String nombre, String imagen, String correo, String telefono, String clave, EnumRol rol, Empresa empresa ) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.correo = correo;
        this.telefono = telefono;
        this.clave = clave;
        this.rol = rol;
        this.empresa = empresa;
        this.fecha = LocalDate.now();
    }

    public List<MovimientoDinero> getMovimientos() {
        System.out.println("FALTA IMPLEMENTAR METODO-- MUESTRA LOS MOVIMIENTO DE UN USUARIO");
        return movimientos;
    }

    public void setMovimientos(List<MovimientoDinero> movimientos) {
        System.out.println("FALTA IMPLEMENTAR METODO***");
        this.movimientos = movimientos;
    }
}