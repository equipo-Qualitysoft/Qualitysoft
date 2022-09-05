package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity @Data
@Table(name="empresas")
public class Empresa {
    //atributos
    @Id
    //Se coloca que el id sea autoincrementable, en unos de los Restcontroller de la Empresa es id para empresas
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empresa")
    private Long idEmpresa;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nit",unique = true)
    private String nit;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
    @OneToMany
    @JoinColumn(name = "usuario_id")
    private List<Usuario> usuarios;
    @OneToMany
    @JoinColumn(name = "movimiento_id")
    private List<MovimientoDinero> movimientos;
    @Column(name = "fecha")
    private LocalDate fecha;
    public Empresa() {
    }
    public Empresa(String nombre, String nit, String telefono, String direccion, List<Usuario> usuarios, List<MovimientoDinero> movimientos) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuarios = usuarios;
        this.movimientos = movimientos;
        this.fecha = LocalDate.now();;
    }
}

