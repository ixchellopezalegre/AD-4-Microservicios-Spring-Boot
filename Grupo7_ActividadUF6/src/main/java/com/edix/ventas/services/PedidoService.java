package com.edix.ventas.services;

import com.edix.ventas.model.entitybeans.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> buscarPorComercial(int idComercial);
    List<Pedido> findAll();
	int hacerPedido(Pedido pedido);
	List<Pedido> buscarPorCliente(int idCliente);
	List<Pedido> buscarPorFechaEntre(String fechaInicio, String fechaFinal);

}
