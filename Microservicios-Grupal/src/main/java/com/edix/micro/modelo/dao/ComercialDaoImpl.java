package com.edix.micro.modelo.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edix.micro.modelo.entityBeans.Comerciale;
import com.edix.micro.modelo.repository.ComercialRepository;


@Service
public class ComercialDaoImpl implements ComercialDao {

	@Autowired ComercialRepository cdao;

	//Alta de un comercial con un objeto Comercial por parámetro
	@Override
	public boolean altaComercial(Comerciale comercial) {
		
		boolean alta = false;
		
		try {
			cdao.save(comercial);
			return alta = true;
		}catch(Exception e){
			e.printStackTrace();
			return alta;
		}
	}

	//Eliminar un comercial buscando por su ID
	@Override
	public boolean eliminarComercial(int idComercial) {
		
		boolean borrar = false;
		Optional<Comerciale> encontrado = cdao.findById(idComercial);
		
		if(encontrado.isPresent()) {
			cdao.deleteById(idComercial);
		return borrar = true;
		}else 
			return borrar;
	}

	//Lista de comerciales por ID.
	@Override
	public Optional<Comerciale> buscarComercial(int idComercial) {
		
		Optional<Comerciale> c = cdao.findById(idComercial);
		
		if(c.isPresent()) {
			return c;
		}else
			return null;
	}

	//Lista de comerciales que tienen pedidos
	@Override
	public List<Comerciale> conPedidos() {
		return cdao.conPedidos();
	}

	//Lista de comerciales que han atendido pedidos a un cliente.
	@Override
	public List<Comerciale> porCliente(int idCliente) {
		return cdao.porCliente(idCliente);
	}
}

