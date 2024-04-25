package co.edu.sena.project2687351.model;

import java.util.Date;

public class Llanta {
    private Integer IdLlanta;
    private String Marca;
    private String Tipo;
    private Integer Modelo;
    private String Dimension;
    private String Diseno;
    private Date FechaLlanta;
    private Double ProfundidadLlanta;

    public Llanta() {}

    public Llanta(Integer idLlanta, String marca, String tipo, Integer modelo,
                  String dimension, String diseno, Date fechaLlanta, Double profundidadLlanta) {
        IdLlanta = idLlanta;
        Marca = marca;
        Tipo = tipo;
        Modelo = modelo;
        Dimension = dimension;
        Diseno = diseno;
        FechaLlanta = fechaLlanta;
        ProfundidadLlanta = profundidadLlanta;
    }

    public Integer getIdLlanta() {
        return IdLlanta;
    }
    public void setIdLlanta(Integer idLlanta) {
        IdLlanta = idLlanta;
    }
    public String getMarca() {
        return Marca;
    }
    public void setMarca(String marca) {
        Marca = marca;
    }
    public String getTipo() {
        return Tipo;
    }
    public void setTipo(String tipo) {
        Tipo = tipo;
    }
    public Integer getModelo() {
        return Modelo;
    }
    public void setModelo(Integer modelo) {Modelo = modelo;}
    public String getDimension() {
        return Dimension;
    }
    public void setDimension(String dimension) {
        Dimension = dimension;
    }
    public String getDiseno() {
        return Diseno;
    }
    public void setDiseno(String diseno) {
        Diseno = diseno;
    }
    public Date getFechaLlanta() {
        return FechaLlanta;
    }
    public void setFechaLlanta(Date fechaLlanta) {
        FechaLlanta = fechaLlanta;
    }
    public Double getProfundidadLlanta() {
        return ProfundidadLlanta;
    }
    public void setProfundidadLlanta(Double profundidadLlanta) {
        ProfundidadLlanta = profundidadLlanta;
    }

    @Override
    public String toString() {
        return "Llanta{" +
                "IdLlanta=" + IdLlanta +
                ", Marca='" + Marca + '\'' +
                ", Tipo='" + Tipo + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", Dimension='" + Dimension + '\'' +
                ", Diseno='" + Diseno + '\'' +
                ", FechaLlanta=" + FechaLlanta +
                ", ProfundidadLlanta=" + ProfundidadLlanta +
                '}';
    }
}