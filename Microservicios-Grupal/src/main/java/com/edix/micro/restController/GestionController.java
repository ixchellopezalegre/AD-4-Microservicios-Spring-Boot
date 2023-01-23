package com.edix.micro.restController;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.micro.modelo.dao.ComercialDao;
import com.edix.micro.modelo.dao.PedidoDao;
import com.edix.micro.modelo.entityBeans.Comerciale;
import com.edix.micro.modelo.entityBeans.Pedido;


@RestController
@RequestMapping("/comercial")
public class GestionController {

	@Autowired ComercialDao cdao;
	@Autowired PedidoDao pdao;
	
	//Esta URL se encarga de dar de alta un comercial, con un nuevo comercial en el body
	@PostMapping("/alta")
	public String darAlta(@RequestBody Comerciale comercial) {
		
		if(cdao.altaComercial(comercial)) {
			return "Alta realizada";
		}else
				return "Alta no realizada";	
	}
	
	//Esta URL se encarga de eliminar un comercial a partir de un ID pasado por parámetro
	@DeleteMapping ("eliminar/{id}")
	public String eliminarComercial(@PathVariable("id") int idComercial) {
		
		if(cdao.eliminarComercial(idComercial)) {
			return "Comercial eliminado";
		}else
				return "Comercial no eliminado";
	}
	 
	//URL que busca un comercial por su ID
	@GetMapping("uno/{id}")
	public Optional<Comerciale> buscarComercial(@PathVariable("id") int idComercial) {
		return cdao.buscarComercial(idComercial);
	}
	
	//Esta URL devuelve la lista de los comerciales que han atendido a clientes dependidendo del id del cliente.
	@GetMapping("bycliente/{id}")
	public List<Comerciale> buscarPorCliente(@PathVariable("id") int idCliente){
		return cdao.porCliente(idCliente);
	}
	
	//URL que devuelve la lista de aquellos comerciales que unicamente han tramitado algun pedido. 
	@GetMapping("conpedidos")
	public List<Comerciale> buscarConPedidos(){
		return cdao.conPedidos();
	}
	
	//URL que muestra, a partir del id del pedido, que comerciales los han gestionado.
	@GetMapping("pedidos/{id}")
	public List<Pedido> buscarPorComercial(@PathVariable("id") int idComercial){
		return pdao.buscarPorComercial(idComercial);
	}
}


