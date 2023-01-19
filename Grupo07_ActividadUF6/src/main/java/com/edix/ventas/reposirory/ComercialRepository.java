package com.edix.ventas.reposirory;

import com.edix.ventas.model.entitybeans.Comercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComercialRepository extends JpaRepository<Comercial, Integer> {
    @Query("select distinct c from Comercial c, Pedido p where p.idComercial=c")
    List<Comercial> conPedidos();

}
