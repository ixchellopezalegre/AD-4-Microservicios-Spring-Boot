package com.edix.ventas.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.ventas.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {
	
	@Autowired
    private ClienteService cServ;

}
