package com.edix.ventas.restcontroller;

import com.edix.ventas.model.entitybeans.Comercial;
import com.edix.ventas.model.entitybeans.Pedido;
import com.edix.ventas.services.ComercialService;
import com.edix.ventas.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoRestController {
    @Autowired
    private PedidoService pServ;

    @GetMapping("/porComercial/{id}")
    public List<Pedido> verPedidosComercial(@PathVariable("id") int idComercial) {
    return pServ.buscarPorComercial(idComercial);
    }

    @GetMapping("/verTodos")
    public List<Pedido> verTodos(){
        return pServ.findAll();
    }

    @PostMapping("/nuevo")
    public String hacerPedido(@RequestBody Pedido pedido){
        return (pServ.hacerPedido(pedido)==1)?"Pedido realizado":"Error en hacer pedido";
    }
    
    @GetMapping("/porCliente/{id}")
    public List<Pedido> verPedidosCliente(@PathVariable("id") int idCliente) {
    return pServ.buscarPorCliente(idCliente);
    }
}
