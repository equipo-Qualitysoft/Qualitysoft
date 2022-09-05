package co.gov.misiontic.qualitysoft.appwebingresoegreso.Util;

import org.springframework.stereotype.Component;

@Component
public class UtilidadesComunes {
    public static String getNombreRol(EnumRol rol){
        switch (rol){
            case ADMIN:
                return "Administrador";
            case USER:
                return "Operario";
            default:
                return "No definido";
        }
    }
    public void mensaje(){
        System.out.println("Mensaje desde la clase útil");
    }
}


