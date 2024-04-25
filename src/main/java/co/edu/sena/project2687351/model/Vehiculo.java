package co.edu.sena.project2687351.model;

public class Vehiculo {
    private Integer IdVehiculo;
    private String Placa;
    private String Marca;
    private String Modelo;
    private String Tipo;
    private Double Kiometraje;
    private Integer Num_Llantas;
    private String Linea;
    private String IdCliente;
    public Vehiculo() {
    }

    public Vehiculo(Integer idVehiculo, String placa, String marca, String modelo, String tipo, Double kiometraje, Integer num_Llantas, String linea, String idCliente) {
        IdVehiculo = idVehiculo;
        Placa = placa;
        Marca = marca;
        Modelo = modelo;
        Tipo = tipo;
        Kiometraje = kiometraje;
        Num_Llantas = num_Llantas;
        Linea = linea;
        IdCliente = idCliente;
    }

    public Integer getIdVehiculo() {
        return IdVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        IdVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Double getKiometraje() {
        return Kiometraje;
    }

    public void setKiometraje(Double kiometraje) {
        Kiometraje = kiometraje;
    }

    public Integer getNum_Llantas() {
        return Num_Llantas;
    }

    public void setNum_Llantas(Integer num_Llantas) {
        Num_Llantas = num_Llantas;
    }

    public String getLinea() {
        return Linea;
    }

    public void setLinea(String linea) {
        Linea = linea;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String idCliente) {
        IdCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "IdVehiculo=" + IdVehiculo +
                ", Placa='" + Placa + '\'' +
                ", Marca='" + Marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", Tipo='" + Tipo + '\'' +
                ", Kiometraje=" + Kiometraje +
                ", Num_Llantas=" + Num_Llantas +
                ", Linea='" + Linea + '\'' +
                ", IdCliente=" + IdCliente +
                '}';
    }
}
