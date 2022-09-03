package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public enum Rol {
    ADMIN("Administrador"),
    USER("Operario");
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRol;
    @Getter @Setter
    @Column(name = "descripcion")
    private String descripcion;
    Rol(String descripcion) {
        this.idRol = ordinal();
        this.descripcion = descripcion;
    }
    Rol() {
    }
}