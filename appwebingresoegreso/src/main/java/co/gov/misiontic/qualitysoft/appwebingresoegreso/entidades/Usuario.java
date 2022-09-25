package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import co.gov.misiontic.qualitysoft.appwebingresoegreso.util.EnumRol;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "imagen")
    private String imagen;
    @Column(name = "correo", unique = true)
    private String correo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "clave")
    private String clave;
    //@ManyToOne
    @Column(name = "rol", nullable = false)
    @Enumerated(value=EnumType.STRING)
    private EnumRol rol;
    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;

    @Column(name = "estado")
    private Boolean estado;

//    @Column(name = "auth0id")
//    private String auth0id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    public Usuario() {
    }

    public Usuario(  String correo,String imagen, String auth0id) {
        this.correo = correo;
        this.imagen = imagen;
       // this.auth0id = auth0id;
    }

    public Usuario(String nombre, String imagen, String correo, String telefono, String clave, EnumRol rol , Empresa empresa ) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.correo = correo;
        this.telefono = telefono;
        this.clave = clave;
        this.rol = rol;
        this.empresa = empresa;
        this.estado = true;
        this.fechaIngreso = LocalDate.now();
    }


}