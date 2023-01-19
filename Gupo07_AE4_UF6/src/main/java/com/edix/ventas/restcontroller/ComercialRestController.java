package com.edix.ventas.restcontroller;

import com.edix.ventas.model.entitybeans.Comercial;
import com.edix.ventas.model.entitybeans.Pedido;
import com.edix.ventas.services.ComercialService;
import com.edix.ventas.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comercial")
public class ComercialRestController {

    @Autowired
    private ComercialService cServ;
    @Autowired
    private PedidoService pServ;


    @PostMapping("/alta")
    public String altaComercial(@RequestBody Comercial comercial){
        return (cServ.insertarUno(comercial)==1)?"Alta confirmada":"Error en alta comercial";
    }
    @PutMapping("/modificar")
    public String modificarComercial(@RequestBody Comercial comercial) {
        return (cServ.modificarUno(comercial) == 1)?"Modificación	confirmada":"Error en modif comercial";
    }

    @DeleteMapping("/eliminar/{id}")
    public String	eliminarComercial(@PathVariable("id") int idComercial) {
        return (cServ.eliminarUno(idComercial) == 1)?"Eliminación confirmada":"Error en elim comercial";
    }

    @GetMapping("/uno/{id}")
    public Comercial verUno(@PathVariable("id") int idComercial) {
        return cServ.findById(idComercial);
    }

    @GetMapping("/conPedidos")
    public List<Comercial> verConPedidos() {
        return cServ.buscarPorPedidos();
    }

    @GetMapping("/byCliente/{id}")
    public List<Comercial> verPorCliente(@PathVariable("id") int idCliente){
        return cServ.buscarPorCliente(idCliente);
    }

    @GetMapping("/pedidos/{id}")
    public List<Pedido> verPedidos(@PathVariable("id") int idComercial){
        return cServ.verPedidos(idComercial);
    }
}
