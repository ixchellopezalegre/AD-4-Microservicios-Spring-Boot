package com.edix.micro.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.micro.modelo.entityBeans.Pedido;
import com.edix.micro.modelo.repository.PedidoRepository;

@Service
public class PedidoDaoImpl implements PedidoDao{

	@Autowired
	PedidoRepository pdao;
	
	//Búsqueda de comercial por el ID de comercial.
	@Override
	public List<Pedido> buscarPorComercial(int idComercial) {
		
		return pdao.gestionComerciales(idComercial);
	}

	
	
}
