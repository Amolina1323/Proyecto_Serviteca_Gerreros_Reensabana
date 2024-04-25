package co.edu.sena.project2687351.model;

public class Services {
    private Integer IdServicio;
    private String NombreServicio;
    private String Estado;
    private Double PrecioServicioLiviano;
    private  Double PrecioServicioMediano;
    private Double PrecioServicioPesado;
    private  String DescripcionServicio;

    public Services() {
    }

    public Services(Integer idServicio, String nombreServicio, String estado, Double precioServicioLiviano, Double precioServicioMediano, Double precioServicioPesado, String descripcionServicio) {
        IdServicio = idServicio;
        NombreServicio = nombreServicio;
        Estado = estado;
        PrecioServicioLiviano = precioServicioLiviano;
        PrecioServicioMediano = precioServicioMediano;
        PrecioServicioPesado = precioServicioPesado;
        DescripcionServicio = descripcionServicio;
    }

    public Integer getIdServicio() {
        return IdServicio;
    }

    public void setIdServicio(Integer idServicio) {
        IdServicio = idServicio;
    }

    public String getNombreServicio() {
        return NombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        NombreServicio = nombreServicio;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Double getPrecioServicioLiviano() {
        return PrecioServicioLiviano;
    }

    public void setPrecioServicioLiviano(Double precioServicioLiviano) {
        PrecioServicioLiviano = precioServicioLiviano;
    }

    public Double getPrecioServicioMediano() {
        return PrecioServicioMediano;
    }

    public void setPrecioServicioMediano(Double precioServicioMediano) {
        PrecioServicioMediano = precioServicioMediano;
    }

    public Double getPrecioServicioPesado() {
        return PrecioServicioPesado;
    }

    public void setPrecioServicioPesado(Double precioServicioPesado) {
        PrecioServicioPesado = precioServicioPesado;
    }

    public String getDescripcionServicio() {
        return DescripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        DescripcionServicio = descripcionServicio;
    }

    @Override
    public String toString() {
        return "Services{" +
                "IdServicio=" + IdServicio +
                ", NombreServicio='" + NombreServicio + '\'' +
                ", Estado='" + Estado + '\'' +
                ", PrecioServicioLiviano=" + PrecioServicioLiviano +
                ", PrecioServicioMediano=" + PrecioServicioMediano +
                ", PrecioServicioPesado=" + PrecioServicioPesado +
                ", DescripcionServicio='" + DescripcionServicio + '\'' +
                '}';
    }
}
