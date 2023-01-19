package com.edix.ventas.reposirory;

import com.edix.ventas.model.entitybeans.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
