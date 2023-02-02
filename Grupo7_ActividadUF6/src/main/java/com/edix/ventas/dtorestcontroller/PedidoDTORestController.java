package com.edix.ventas.dtorestcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.ventas.dtoservice.PedidoDTOServ;
import com.edix.ventas.model.dto.PedidoDTO;

@RestController
@RequestMapping("/dto/pedido")
public class PedidoDTORestController {
    @Autowired
    PedidoDTOServ pServ;

    @GetMapping("/verUno/{id}")
    public ResponseEntity<?> verUno(@PathVariable("id") int idPedido) {
        PedidoDTO pdto = pServ.buscarUno(idPedido);
        if (pdto == null) {
            return ResponseEntity.status(404).body("El pedido no existe");
        }
        return ResponseEntity.status(302).body(pdto);
    }

    @GetMapping("/verTodos")
    public ResponseEntity<?> verTodos() {
        if (pServ.buscarTodos() != null) {
            return ResponseEntity.status(302).body(pServ.buscarTodos());
        }
        return ResponseEntity.status(404).body("No encontrado");
    }
    @GetMapping("/verPorCliente/{nombre}")
    public ResponseEntity<?> verPorCliente(@PathVariable("nombre") String nombre) {
        if (pServ.buscarPorCliente(nombre) != null) {
            return ResponseEntity.status(302).body(pServ.buscarPorCliente(nombre));
        }
        return ResponseEntity.status(404).body("No encontrado");
    }
}
