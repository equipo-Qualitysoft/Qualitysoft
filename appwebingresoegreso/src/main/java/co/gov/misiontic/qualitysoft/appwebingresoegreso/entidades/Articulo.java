package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name = "articulos")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idArticulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private Long precio;

    public Articulo() {
    }
    public Articulo(String descripcion, Long precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

}
