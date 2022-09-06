package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="empresas")
public class Empresa {
    //atributos
    @Setter @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empresa")
    private Long idEmpresa;
    @Setter @Getter
    @Column(name = "nombre")
    private String nombre;
    @Setter @Getter
    @Column(name = "nit")
    private String nit;
    @Setter @Getter
    @Column(name = "telefono")
    private String telefono;
    @Setter @Getter
    @Column(name = "direccion")
    private String direccion;
    @OneToMany
    @JoinColumn(name = "usuarios")
    private List<Usuario> usuarios;
    @OneToMany
    @JoinColumn(name = "movimeintos")
    private List<MovimientoDinero> movimientos;
    @Setter @Getter
    @Column(name = "fecha")
    private LocalDate fecha;
    public Empresa() {
    }
    public Empresa(String nombre, String nit, String telefono, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha = LocalDate.now();;
    }

    public List<Usuario> getUsuarios() {
        System.out.println("IMPLEMENTAR METODO - MUESTRA LOS USUARIOS QUE TIENE LA EMPRESA");
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        System.out.println("FALTA IMPLEMENTAR METODO");
        this.usuarios = usuarios;
    }

    public List<MovimientoDinero> getMovimientos() {
        System.out.println("IMPLEMENTAR METODO - MUESTRA LOS MOVIMIENTOS  QUE TIENE LA EMPRESA");
        return movimientos;
    }

    public void setMovimientos(List<MovimientoDinero> movimientos) {
        System.out.println("FALTA IMPLEMENTAR METODO");
        this.movimientos = movimientos;
    }
}

