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

    public List<Pedido> buscarPorComercial(int idComercial){

        System.out.println("-----                   -------------");
        System.out.println(pRepo.findByComercial_IdComercial(idComercial));

        System.out.println("-----                   -------------");

        return pRepo.findByComercial_IdComercial(idComercial);
    }

    @Override
    public List<Pedido> findAll() {
        System.out.println(pRepo.findAll());
        return pRepo.findAll();
    }
}
