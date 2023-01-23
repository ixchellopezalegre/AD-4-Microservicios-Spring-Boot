package com.edix.micro.modelo.dao;


import java.util.List;
import java.util.Optional;

import com.edix.micro.modelo.entityBeans.Comerciale;

public interface ComercialDao {

	boolean altaComercial(Comerciale comercial);
	boolean eliminarComercial(int idComercial);
	Optional<Comerciale> buscarComercial(int idComercial);
	List<Comerciale> conPedidos();
	List<Comerciale> porCliente(int idCliente);
	
	
	

}
