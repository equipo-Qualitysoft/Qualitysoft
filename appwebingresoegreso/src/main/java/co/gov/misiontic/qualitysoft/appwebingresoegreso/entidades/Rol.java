package co.gov.misiontic.qualitysoft.appwebingresoegreso.entidades;

public enum Rol {
    ADMIN(1, "Administrador"),
    USER(2, "Operario");
    private int idRol;
    private String descripcion;

    Rol(int idRol, String descripcion) {
        this.idRol = idRol;
        this.descripcion = descripcion;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + idRol +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}