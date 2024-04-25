package co.edu.sena.project2687351.model;
public class Rol {
    private  Integer IdRol;
    private  String NombreRol;

    public Rol() {
    }

    public Rol(Integer idRol, String nombreRol) {
        IdRol = idRol;
        NombreRol = nombreRol;
    }

    public Integer getIdRol() {
        return IdRol;
    }

    public void setIdRol(Integer idRol) {
        IdRol = idRol;
    }

    public String getNombreRol() {
        return NombreRol;
    }

    public void setNombreRol(String nombreRol) {
        NombreRol = nombreRol;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "IdRol=" + IdRol +
                ", NombreRol='" + NombreRol + '\'' +
                '}';
    }
}