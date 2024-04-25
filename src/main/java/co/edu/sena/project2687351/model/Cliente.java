package co.edu.sena.project2687351.model;

public class Cliente {
    private String IdCliente;
    private String Nombre;
    private String Empresa;
    private String Documento;
    private String Correo;
    private Integer Telefono;
    private String Direccion;


    public Cliente() {}
    public Cliente(String idCliente, String nombre, String empresa, String documento,
                   String correo, Integer telefono, String direccion) {
        IdCliente = idCliente;
        Nombre = nombre;
        Empresa = empresa;
        Documento = documento;
        Correo = correo;
        Telefono = telefono;
        Direccion = direccion;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String idCliente) {
        IdCliente = idCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String empresa) {
        Empresa = empresa;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public Integer getTelefono() {
        return Telefono;
    }

    public void setTelefono(Integer telefono) {
        Telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "IdCliente=" + IdCliente +
                ", Nombre='" + Nombre + '\'' +
                ", Empresa='" + Empresa + '\'' +
                ", Documento=" + Documento +
                ", Correo=" + Correo +
                ", Telefono='" + Telefono + '\'' +
                ", Direccion='" + Direccion + '\'' +
                '}';
    }
}
