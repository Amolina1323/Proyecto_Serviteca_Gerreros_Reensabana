package co.edu.sena.project2687351.model;

public class Usuario {
    private Integer Documento;
    private String Nombre;
    private String Apellido;
    private String Contrasena;
    private Integer Telefono;
    private String Correo;
    private String Direccion;
    private  String Rol;

    public Usuario() {
    }

    public Usuario( Integer documento, String nombre, String apellido, String contrasena, Integer telefono, String correo, String direccion, String rol) {
        Documento = documento;
        Nombre = nombre;
        Apellido = apellido;
        Contrasena = contrasena;
        Telefono = telefono;
        Correo = correo;
        Direccion = direccion;
        Rol = rol;
    }


    public Integer getDocumento() {
        return Documento;
    }

    public void setDocumento(Integer documento) {
        Documento = documento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public Integer getTelefono() {
        return Telefono;
    }

    public void setTelefono(Integer telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Documento=" + Documento +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Contrasena='" + Contrasena + '\'' +
                ", Telefono=" + Telefono +
                ", Correo='" + Correo + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", Rol='" + Rol + '\'' +
                '}';
    }
}
