package co.edu.sena.project2687351.model;

import java.util.Date;

public class DServicio {
    private Integer IdDetalleServicio;
    private Double PrecioDetalleServicio;
    private Date Fecha;
    private String IdVehiculo;
    private Integer IdServicio;
    private Integer IdUsuario;
    private String DescripcionServicio;

    public DServicio() {}
    public DServicio(Integer idDetalleServicio,
                     Double precioDetalleServicio,
                     Date fecha, String idVehiculo,
                     Integer idServicio,
                     Integer idUsuario,
                     String descripcionServicio) {
        IdDetalleServicio = idDetalleServicio;
        PrecioDetalleServicio = precioDetalleServicio;
        Fecha = fecha;
        IdVehiculo = idVehiculo;
        IdServicio = idServicio;
        IdUsuario = idUsuario;
        DescripcionServicio = descripcionServicio;
    }

    public Integer getIdDetalleServicio() {
        return IdDetalleServicio;
    }
    public void setIdDetalleServicio(Integer idDetalleServicio) {
        IdDetalleServicio = idDetalleServicio;
    }
    public Double getPrecioDetalleServicio() {
        return PrecioDetalleServicio;
    }
    public void setPrecioDetalleServicio(Double precioDetalleServicio) { PrecioDetalleServicio = precioDetalleServicio;}

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }
    public String getIdVehiculo() {
        return IdVehiculo;
    }
    public void setIdVehiculo(String idVehiculo) {
        IdVehiculo = idVehiculo;
    }
    public Integer getIdServicio() {
        return IdServicio;
    }
    public void setIdServicio(Integer idServicio) {
        IdServicio = idServicio;
    }
    public Integer getIdUsuario() {
        return IdUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }
    public String getDescripcionServicio() {
        return DescripcionServicio;
    }
    public void setDescripcionServicio(String descripcionServicio) {
        DescripcionServicio = descripcionServicio;
    }

    @Override
    public String toString() {
        return "DServicio{" +
                "IdDetalleServicio=" + IdDetalleServicio +
                ", PrecioDetalleServicio=" + PrecioDetalleServicio +
                ", Fecha=" + Fecha +
                ", IdVehiculo=" + IdVehiculo +
                ", IdServicio=" + IdServicio +
                ", IdUsuario=" + IdUsuario +
                ", DescripcionServicio='" + DescripcionServicio + '\'' +
                '}';
    }
}
