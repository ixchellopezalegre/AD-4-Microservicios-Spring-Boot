package com.edix.ventas.services;


import com.edix.ventas.model.entitybeans.Comercial;
import com.edix.ventas.model.entitybeans.Pedido;

import java.util.List;

public interface ComercialService {

    Comercial findById(int idComercial);
    int insertarUno(Comercial comercial);

    int modificarUno(Comercial comercial);

    int eliminarUno(int idComercial);

    List<Comercial> buscarPorCliente(int idCliente);

    List<Comercial> buscarPorPedidos();

    List<Pedido> buscarPedPorComer(int idComercial);
}