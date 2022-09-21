package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "clientes_proveedores")
public class ClienteProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClienteProveedor;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "documento", unique = true)
    private String documento;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "tipo_cp")
    private boolean tipoCP; //true = cliente, false = proveedor

    public ClienteProveedor() {
    }
    public ClienteProveedor(String nombre, String documento, String telefono, String direccion, boolean tipoCP) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipoCP = tipoCP;
    }
}
