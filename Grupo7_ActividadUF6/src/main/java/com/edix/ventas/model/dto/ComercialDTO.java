package com.edix.ventas.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class ComercialDTO implements Serializable {
    /*
    Esta clase es un DTO (Data Transfer Object)
    que se utiliza para transferir datos entre capas.
     */
    private static final long serialVersionUID = 1L;
    private Integer idComercial;
    private String nombreCompleto;
    private Double comision;

    public ComercialDTO() {
    }

    public ComercialDTO(Integer idComercial, String nombreCompleto, Double comision) {
        super();
        this.idComercial = idComercial;
        this.nombreCompleto = nombreCompleto;
        this.comision = comision;
    }

    public Integer getIdComercial() {
        return idComercial;
    }
    public void setIdComercial(Integer idComercial) {
        this.idComercial = idComercial;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public Double getComision() {
        return comision;
    }
    public void setComision(Double comision) {
        this.comision = comision;
    }

    @Override
    public String toString() {
        return "ComercialDTO [idComercial=" + idComercial
                + ", nombreCompleto=" + nombreCompleto + '\''
                + ", comision=" + comision + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComercialDTO that = (ComercialDTO) o;
        return Objects.equals(idComercial, that.idComercial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComercial);
    }
}
