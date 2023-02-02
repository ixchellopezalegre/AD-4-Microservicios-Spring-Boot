package com.edix.ventas.dtorestcontroller;

import com.edix.ventas.model.dto.ClienteDTO;
import com.edix.ventas.dtoservice.ClienteDTOServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dto/cliente")
public class ClienteDTORestController {

    @Autowired
    private ClienteDTOServ cServ;

    @GetMapping("/verUno/{id}")
    public ResponseEntity<?> verUno(@PathVariable("id") int idCliente) {
        ClienteDTO cdto = cServ.buscarUno(idCliente);
        if (cdto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente no existe");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(cdto);
    }

    @GetMapping("/verTodos")
    public ResponseEntity<?> verTodos() {
        if (cServ.buscarTodos() != null) {
            return ResponseEntity.status(302).body(cServ.buscarTodos());
        }
        return ResponseEntity.status(404).body("No encontrado");
    }

    @GetMapping("/verPorCategoria/{categoria}")
    public ResponseEntity<?> verPorCategoria(@PathVariable("categoria") int categoria) {
        if (cServ.buscarPorCategoria(categoria) != null) {
            return ResponseEntity.status(302).body(cServ.buscarPorCategoria(categoria));
        }
        return ResponseEntity.status(404).body("No existe la categoría");
    }
}
