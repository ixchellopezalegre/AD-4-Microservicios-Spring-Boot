package com.edix.ventas.dtoservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ventas.model.dto.ClienteDTO;
import com.edix.ventas.model.entitybeans.Cliente;
import com.edix.ventas.repository.ClienteRepository;

@Service
public class ClienteDTOServI  implements ClienteDTOServ{

    @Autowired
    private ClienteRepository  cRepo;

    @Override
    public ClienteDTO buscarUno(int idCliente){
        Cliente cliente = cRepo.findById(idCliente).orElse(null);
        if (cliente != null){
            return convertirClienteDTO(cliente);
        }
        return null;
    }
    @Override
    public List<ClienteDTO> buscarTodos(){
        List<Cliente> clientes = cRepo.findAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        for (Cliente cliente : clientes){
            clientesDTO.add(convertirClienteDTO(cliente));
        }
        System.out.println("Clientes: " + clientesDTO);
        return clientesDTO;
    }

    @Override
    public List<ClienteDTO> buscarPorCategoria(Integer categoria){

        List<Cliente> clientes = cRepo.findByCategoria(categoria);
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        for (Cliente cliente : clientes){
            clientesDTO.add(convertirClienteDTO(cliente));
        }
        return clientesDTO;
    }

    private ClienteDTO convertirClienteDTO(Cliente cliente){

        ClienteDTO cdto = new ClienteDTO();
        cdto.setIdCliente(cliente.getIdCliente());
        cdto.setNombreCompleto(cliente.getNombre() + " " + cliente.getApellido1() + " " + cliente.getApellido2());
        cdto.setCiudad(cliente.getCiudad());
        cdto.setCategoria(cliente.getCategoria());
        return cdto;
    }
}
