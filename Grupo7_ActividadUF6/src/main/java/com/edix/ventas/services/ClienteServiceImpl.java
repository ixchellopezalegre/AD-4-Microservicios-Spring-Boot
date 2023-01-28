package com.edix.ventas.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.edix.ventas.repository.ClienteRepository;

@Repository
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
    private ClienteRepository cRepo;

}
