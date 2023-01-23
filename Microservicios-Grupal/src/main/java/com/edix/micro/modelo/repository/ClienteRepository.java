package com.edix.micro.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.micro.modelo.entityBeans.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
