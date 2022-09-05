package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity @Data
@Table(name="empresas")
public class Empresa  {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empresa")
    private Long idEmpresa;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nit")
    private String nit;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
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

    public List<Usuario> getUsuariosByEmpresa() {
        System.out.println("Implementar metodo - buscar usuarios por empresa");
        return null;
    }

    public List<MovimientoDinero> getMovimientosByEmpresa() {
        System.out.println("Implementar metodo - buscar moviwientos por empresa");
        return null;
    }
}

