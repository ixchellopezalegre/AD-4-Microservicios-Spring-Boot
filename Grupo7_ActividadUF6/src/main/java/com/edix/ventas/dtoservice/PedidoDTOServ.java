package com.edix.ventas.dtoservice;

import java.util.List;

import com.edix.ventas.model.dto.PedidoDTO;

public interface PedidoDTOServ {

	PedidoDTO buscarUno(int idPedido);
	List<PedidoDTO> buscarPorCliente(String nombre);
	 List<PedidoDTO> buscarTodos();
}
