package com.edix.micro.modelo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.micro.modelo.entityBeans.Comerciale;

public interface ComercialRepository extends JpaRepository<Comerciale, Integer>{
	
	//Query para seleccionar los comerciales que atienden pedidos a los clientes que se pasen por parámetro
	@Query("select distinct c from Comerciale c, Pedido p where p.comerciale.idComercial= c and  p.cliente.idCliente =?1")
	List<Comerciale> porCliente(int idCliente);
	
	//Query que selecciona aquellos comerciales que han gestionado pedidos.
	@Query("select distinct c from Comerciale c, Pedido p where p.comerciale.idComercial = c")
	List<Comerciale> conPedidos();
}
