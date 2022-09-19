package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import lombok.Data;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name="empresas")
public class Empresa {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmpresa;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nit", unique = true)
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
        this.fecha =LocalDate.now();;
    }



}

