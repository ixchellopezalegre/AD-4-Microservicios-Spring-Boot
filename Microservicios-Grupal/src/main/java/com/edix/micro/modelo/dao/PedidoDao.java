package com.edix.micro.modelo.dao;

import java.util.List;

import com.edix.micro.modelo.entityBeans.Pedido;

public interface PedidoDao {

	List<Pedido> buscarPorComercial(int idComercial);
}
