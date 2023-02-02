package com.edix.ventas.dtoservice;

import java.util.List;

import com.edix.ventas.model.dto.ClienteDTO;

public interface ClienteDTOServ{
    ClienteDTO buscarUno(int idCliente);
    List<ClienteDTO> buscarTodos();
    List<ClienteDTO> buscarPorCategoria(Integer categoria);

}
