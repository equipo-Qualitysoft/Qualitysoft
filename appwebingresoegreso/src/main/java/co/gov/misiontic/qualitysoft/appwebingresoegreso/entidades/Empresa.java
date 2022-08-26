package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

//Creación de la clase empresa

public class Empresa {

    //creación de los atributos con respecto al diagrama UML
    private String nombre;
    private String direccion;
    private int telefono;
    private int nit;

    //creación del constructor segun el diagrama UML

    public Empresa(String nombre, String direccion, int telefono, int nit) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
    }

    //realización de los Definition of Done

    //crear nueva instancia de la clase Empresa



     //Es posible leer el nombre de la empresa
    public String getNombre() {
        return nombre;
    }
     //Es posible modificar el nombre de la empresa
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Es posible leer la direccion de la empresa
    public String getDireccion() {
        return direccion;
    }

    //Es posible modificar la direccion de la empresa
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //Es posible leer el telefono de la empresa
    public int getTelefono() {
        return telefono;
    }

    //Es posible modificar el telefono de la empresa
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    //Es posible leer el nit de la empresa
    public int getNit() {
        return nit;
    }

    //Es posible modificar el nit de la empresa
    public void setNit(int nit) {
        this.nit = nit;
    }
}