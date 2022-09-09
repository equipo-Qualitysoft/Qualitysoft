//package co.gov.misiontic.qualitysoft.appwebingresoegreso.Util;
//
//import lombok.Getter;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "roles")
//public enum Rol {
//    ADMIN("Administrador"),
//    USER("Operario");
//    @Getter
//    //@OneToOne
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int idRol;
//    private String descripcion;
//    Rol(String descripcion) {
//        this.idRol = ordinal();
//        this.descripcion = descripcion;
//    }
//    Rol() {
//
//    }
//}