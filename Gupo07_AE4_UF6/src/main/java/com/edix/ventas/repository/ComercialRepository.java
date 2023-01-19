package com.edix.ventas.repository;

import com.edix.ventas.model.entitybeans.Comercial;
import com.edix.ventas.model.entitybeans.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComercialRepository extends JpaRepository<Comercial, Integer> {
    @Query("select distinct c from Comercial c, Pedido p where p.comercial=c")
    List<Comercial> conPedidos();

   @Query("select distinct p.comercial from Pedido p where p.cliente.idCliente = ?1")
    List<Comercial> porCliente(int idCliente);

   @Query("select p from Pedido p where p.comercial.idComercial = ?1")
    List<Pedido> verPedidos(int idComercial);

}
