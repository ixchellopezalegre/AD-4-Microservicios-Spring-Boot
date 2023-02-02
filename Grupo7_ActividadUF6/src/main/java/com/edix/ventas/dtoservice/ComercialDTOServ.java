package com.edix.ventas.dtoservice;

import java.util.List;

import com.edix.ventas.model.dto.ComercialDTO;

public interface ComercialDTOServ {
    ComercialDTO buscarUno(int idComercial);
    List<ComercialDTO> buscarTodos();
    List<ComercialDTO> buscarPorComisionMayor(double comision);
}
