package com.edix.ventas.services;

import com.edix.ventas.model.entitybeans.Pedido;
import com.edix.ventas.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pRepo;

    //Esto hace lo mismo que comercial/pedidos/id
    @Override
    public List<Pedido> buscarPorComercial(int idComercial){
        return pRepo.findByComercial_IdComercial(idComercial);
    }

    @Override
    public List<Pedido> findAll() {
        return pRepo.findAll();
    }
    
    @Override
    public int hacerPedido(Pedido pedido) {
        int filas = 0;
        try {
        	pRepo.save(pedido); filas = 1;
        }catch(Exception e) { e.printStackTrace();
        }
        return filas;
    }

	@Override
	public List<Pedido> buscarPorCliente(int idCliente) {
		return pRepo.findByCliente_IdCliente(idCliente);
	}
}
