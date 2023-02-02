package com.edix.ventas.dtoservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ventas.model.dto.ComercialDTO;
import com.edix.ventas.model.entitybeans.Comercial;
import com.edix.ventas.repository.ComercialRepository;

@Service
public class ComercialDTOServI implements ComercialDTOServ {

	@Autowired
    private ComercialRepository cRepo;
    
    public ComercialDTO  buscarUno(int idComercial){
        Comercial comercial = cRepo.findById(idComercial).orElse(null);
        if (comercial != null){
            return convertirComercialDTO(comercial);
        }
        return null;
    }
    
    public List<ComercialDTO> buscarTodos(){
        List<Comercial> comerciales = cRepo.findAll();
        List<ComercialDTO> comercialesDTO = new ArrayList<>();
        for (Comercial comercial : comerciales){
            comercialesDTO.add(convertirComercialDTO(comercial));
        }
        System.out.println("Comerciales: " + comercialesDTO);
        return comercialesDTO;
    }
    
    public List<ComercialDTO> buscarPorComisionMayor(double comision){
        List<Comercial> comerciales = cRepo.findByComisionGreaterThan(comision);
        List<ComercialDTO> comercialesDTO = new ArrayList<>();
        for (Comercial comercial : comerciales){
            comercialesDTO.add(convertirComercialDTO(comercial));
        }
        System.out.println("Comerciales: " + comercialesDTO);
        return comercialesDTO;
    }
    
    private ComercialDTO convertirComercialDTO(Comercial comercial){
        ComercialDTO cdto = new ComercialDTO();
        cdto.setIdComercial(comercial.getIdComercial());
        cdto.setNombreCompleto(comercial.getNombre() + " " + comercial.getApellido1() + " " + comercial.getApellido2());
        cdto.setComision(comercial.getComision());
        return cdto;
    }
}
