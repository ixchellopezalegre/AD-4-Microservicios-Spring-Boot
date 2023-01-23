package com.edix.micro.modelo.entityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pedidos database table.
 * 
 */
@Entity
@Table(name="pedidos")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private int idPedido;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private double total;

	//uni-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//uni-directional many-to-one association to Comerciale
	@ManyToOne
	@JoinColumn(name="id_comercial")
	private Comerciale comerciale;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Comerciale getComerciale() {
		return this.comerciale;
	}

	public void setComerciale(Comerciale comerciale) {
		this.comerciale = comerciale;
	}

}