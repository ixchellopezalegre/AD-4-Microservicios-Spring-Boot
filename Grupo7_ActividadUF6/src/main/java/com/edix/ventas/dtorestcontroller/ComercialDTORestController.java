package com.edix.ventas.dtorestcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.ventas.dtoservice.ComercialDTOServ;
import com.edix.ventas.model.dto.ComercialDTO;

@RestController
@RequestMapping("/dto/comercial")
public class ComercialDTORestController {
    @Autowired
    ComercialDTOServ cServ;

    @GetMapping("/verUno/{id}")
    public ResponseEntity<?> verUno(@PathVariable("id") int idComercial) {
        ComercialDTO cdto = cServ.buscarUno(idComercial);
        if (cdto == null) {
            return ResponseEntity.status(404).body("El comercial no existe");
        }
        return ResponseEntity.status(302).body(cdto);
    }

    @GetMapping("/verTodos")
    public ResponseEntity<?> verTodos() {
        if (cServ.buscarTodos() != null) {
            return ResponseEntity.status(302).body(cServ.buscarTodos());
        }
        return ResponseEntity.status(404).body("No encontrado");
    }

    @GetMapping("verPorComision/{comision}")
    public ResponseEntity<?> verPorComision(double comision) {
        if (cServ.buscarPorComisionMayor(comision) != null) {
            return ResponseEntity.status(302).body(cServ.buscarPorComisionMayor(comision));
        }
        return ResponseEntity.status(404).body("No existe la comisión");
    }
}
