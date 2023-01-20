package com.edix.ventas.restcontroller;

import com.edix.ventas.model.entitybeans.Pedido;
import com.edix.ventas.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoRestController {
    @Autowired
    private PedidoService pServ;

    @GetMapping("/verPedidos/{id}")
    public List<Pedido> verPedidos(@PathVariable("id") int idComercial) {
    return pServ.buscarPorComercial(idComercial);
    }

    @GetMapping("/verTodos")
    public List<Pedido> verTodos(){
        return pServ.findAll();
    }
}
