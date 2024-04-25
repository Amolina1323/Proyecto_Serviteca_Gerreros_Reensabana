package co.edu.sena.project2687351.model;

import java.util.Date;

public class Venta {
    private Integer IdVenta;
    private Double PrecioDetalleVenta;
    private Date FechaInicio;
    private Date FechaFin;
    private Integer IdLlanta;
    private Integer IdUsuario;
    private String IdCliente;
    private String DescripcionVenta;

    public Venta() {
    }

    public Venta(Integer idVenta, Double precioDetalleVenta, Date fechaInicio, Date fechaFin, Integer idLlanta, Integer idUsuario, String idCliente, String descripcionVenta) {
        IdVenta = idVenta;
        PrecioDetalleVenta = precioDetalleVenta;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        IdLlanta = idLlanta;
        IdUsuario = idUsuario;
        IdCliente = idCliente;
        DescripcionVenta = descripcionVenta;

    }

    public Integer getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(Integer idVenta) {
        IdVenta = idVenta;
    }

    public Double getPrecioDetalleVenta() {
        return PrecioDetalleVenta;
    }

    public void setPrecioDetalleVenta(Double precioDetalleVenta) {
        PrecioDetalleVenta = precioDetalleVenta;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        FechaFin = fechaFin;
    }

    public Integer getIdLlanta() {
        return IdLlanta;
    }

    public void setIdLlanta(Integer idLlanta) {
        IdLlanta = idLlanta;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String idCliente) {
        IdCliente = idCliente;
    }

    public String getDescripcionVenta() {
        return DescripcionVenta;
    }

    public void setDescripcionVenta(String descripcionVenta) {
        DescripcionVenta = descripcionVenta;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "IdVenta=" + IdVenta +
                ", PrecioDetalleVenta=" + PrecioDetalleVenta +
                ", FechaInicio=" + FechaInicio +
                ", FechaFin=" + FechaFin +
                ", IdLlanta=" + IdLlanta +
                ", IdUsuario=" + IdUsuario +
                ", IdCliente=" + IdCliente +
                ", DescripcionVenta='" + DescripcionVenta + '\'' +
                '}';
    }
}
