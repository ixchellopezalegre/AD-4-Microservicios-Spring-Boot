package com.edix.ventas.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class ClienteDTO implements Serializable {
    /*
    Esta clase es un DTO (Data Transfer Object)
    que se utiliza para transferir datos entre capas.
     */
    private static final long serialVersionUID = 1L;

    private int idCliente;
    private String nombreCompleto;
    private String ciudad;
    private Integer categoria;

    public ClienteDTO() {
    }

    public ClienteDTO(int idCliente, String nombreCompleto, String ciudad, Integer categoria) {
        super();
        this.idCliente = idCliente;
        this.nombreCompleto = nombreCompleto;
        this.ciudad = ciudad;
        this.categoria = categoria;
    }

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public Integer getCategoria() {
        return categoria;
    }
    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ClienteDTO [idCliente=" + idCliente
                + ", nombre=" + nombreCompleto +'\''
                + ", ciudad=" + ciudad +'\''
                + ", categoria=" + categoria + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDTO that = (ClienteDTO) o;
        return idCliente == that.idCliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente);
    }
}
