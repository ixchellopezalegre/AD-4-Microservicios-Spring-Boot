package com.edix.micro.modelo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.edix.micro.modelo.entityBeans.Cliente;
import com.edix.micro.modelo.repository.ClienteRepository;

public class ClienteDaoImpl implements ClienteDao {

	@Autowired ClienteRepository cdao;
	
	//Busqueda de un cliente por ID
	@Override
	public int buscarCliente(int idCliente) {
		
		Optional<Cliente> cliente = cdao.findById(idCliente);
		
		if(cliente.isPresent())
			return idCliente;
		else
			return 0;
	}

}
