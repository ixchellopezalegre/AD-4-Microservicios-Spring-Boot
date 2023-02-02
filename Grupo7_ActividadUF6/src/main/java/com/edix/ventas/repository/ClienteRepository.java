package com.edix.ventas.repository;

import com.edix.ventas.model.entitybeans.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	List<Cliente> findByCategoria(Integer categoria);
	}
