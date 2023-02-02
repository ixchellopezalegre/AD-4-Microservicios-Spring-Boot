package com.edix.ventas.dtoservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ventas.model.dto.PedidoDTO;
import com.edix.ventas.model.entitybeans.Pedido;
import com.edix.ventas.repository.PedidoRepository;

@Service
public class PedidoDTOServI implements PedidoDTOServ{
    @Autowired
    private PedidoRepository pRepo;

    public PedidoDTO buscarUno(int idPedido){
        Pedido pedido = pRepo.findById(idPedido).orElse(null);
        if (pedido != null){
            return convertirPedidoDTO(pedido);
        }
        return null;
    }
    
    public List<PedidoDTO> buscarTodos(){
        List<Pedido> pedidos = pRepo.findAll();
        List<PedidoDTO> pedidosDTO = new ArrayList<>();
        for (Pedido pedido : pedidos){
            pedidosDTO.add(convertirPedidoDTO(pedido));
        }
        System.out.println("Pedidos: " + pedidosDTO);
        return pedidosDTO;
    }

    public List<PedidoDTO> buscarPorCliente(String nombre)     {
        List<Pedido> pedidos = pRepo.findByCliente_Nombre(nombre);
        List<PedidoDTO> pedidosDTO = new ArrayList<>();
        for (Pedido pedido : pedidos){
            pedidosDTO.add(convertirPedidoDTO(pedido));
        }
        System.out.println("Pedidos: " + pedidosDTO);
        return pedidosDTO;
    }
    
    private PedidoDTO convertirPedidoDTO(Pedido pedido){
        PedidoDTO pdto = new PedidoDTO();
        pdto.setIdPedido(pedido.getIdPedido());
        pdto.setFecha(pedido.getFecha().toString());
        pdto.setComercial(pedido.getComercial().getNombre() + " " + pedido.getComercial().getApellido1() + " " + pedido.getComercial().getApellido2());
        pdto.setCliente(pedido.getCliente().getNombre() + " " + pedido.getCliente().getApellido1() + " " + pedido.getCliente().getApellido2());
        return pdto;
    }
}
