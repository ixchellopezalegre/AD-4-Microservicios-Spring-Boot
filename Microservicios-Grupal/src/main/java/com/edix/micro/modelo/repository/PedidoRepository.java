package com.edix.micro.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.micro.modelo.entityBeans.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	//Query para selecionar los pedidos que correspondan a un ID de comercial pasado por parámetro.
	@Query("select p from Pedido  p where p.comerciale.idComercial =?1")
	List<Pedido> gestionComerciales(int idComercial);
}
