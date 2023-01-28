package com.edix.ventas.repository;

import com.edix.ventas.model.entitybeans.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    @Query("select p from Pedido p where p.comercial.idComercial = ?1")
    public List<Pedido> buscarPorComercial(int idComercial);

    public List<Pedido> findByComercial_IdComercial(int idComercial);
    
    public List<Pedido> findByCliente_IdCliente(int idCliente);
    
    public List<Pedido> findPedidoByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);

}
