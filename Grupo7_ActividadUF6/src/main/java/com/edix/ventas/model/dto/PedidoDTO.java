package com.edix.ventas.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class PedidoDTO implements Serializable {
    /*
    Esta clase es un DTO (Data Transfer Object)
    que se utiliza para transferir datos entre capas.
     */
    private static final long serialVersionUID = 1L;

    private Integer idPedido;
    private String fecha;
    private String cliente;
    private String comercial;

    public PedidoDTO() {
    }

    public PedidoDTO(Integer idPedido, String fecha, String cliente, String comercial) {
        super();
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.cliente = cliente;
        this.comercial = comercial;
    }

    public Integer getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getComercial() {
        return comercial;
    }
    public void setComercial(String comercial) {
        this.comercial = comercial;
    }

    @Override
    public String toString() {
        return "PedidoDTO [idPedido=" + idPedido
                + ", fecha=" + fecha
                + ", cliente=" + cliente
                + ", comercial=" + comercial + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoDTO pedidoDTO = (PedidoDTO) o;
        return Objects.equals(idPedido, pedidoDTO.idPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido);
    }
}
