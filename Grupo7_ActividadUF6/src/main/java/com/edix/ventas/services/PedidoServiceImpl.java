package com.edix.ventas.services;

import com.edix.ventas.model.entitybeans.Pedido;
import com.edix.ventas.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
	
    @Autowired
    private PedidoRepository pRepo;

    //Esto hace lo mismo que comercial/pedidos/id
    @Override
    /**
     * Busca los pedidos de un Comercial en la base de datos por su ID.
     * @param idComercial ID del Comercial a buscar
     * @return la lista de pedidos de ese Comercial si lo encuentra,
     *  null si no lo encuentra
     */
    public List<Pedido> buscarPorComercial(int idComercial){
        return pRepo.findByComercial_IdComercial(idComercial);
    }

    @Override
    /**
     * Busca todos los pedidos de la base de datos
     * @return Lista de todos los pedidos
     */
    public List<Pedido> findAll() {
        return pRepo.findAll();
    }
    
    @Override
    /**
     * Inserta un pedido en la base de datos
     * @param pedido Pedido a insertar
     * @return 1 si se inserta correctamente, 0 si no se inserta
     */
    public int hacerPedido(Pedido pedido) {
        int filas = 0;
        try {
        	pRepo.save(pedido); filas = 1;
        }catch(Exception e) { e.printStackTrace();
        }
        return filas;
    }

	@Override
    /**
     * Busca los pedidos de un Cliente en la base de datos
     * @param idCliente ID del Cliente a buscar
     * @return Lista de pedidos de ese Cliente, null si no lo encuentra
     * 
     */
	public List<Pedido> buscarPorCliente(int idCliente) {
		return pRepo.findByCliente_IdCliente(idCliente);
	}

	@Override
    /**
     * Busca los pedidos de un intervalo de fecha en la base de datos
     * @param fechaInicio Fecha de inicio del intervalo.
     * @param fechaFinal Fecha final del intervalo.
     * @return Lista de pedidos realizados entre esa fecha, null si no lo encuentra
     */
	public List<Pedido> buscarPorFechaEntre(String fechaInicio, String fechaFinal) {
		//Si necesitamos un formateador para LocalDate, es este.
		//DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate out = LocalDate.parse(fechaInicio);
		LocalDate out2 = LocalDate.parse(fechaFinal);
		return pRepo.findPedidoByFechaBetween(out, out2);
	}
	
}
