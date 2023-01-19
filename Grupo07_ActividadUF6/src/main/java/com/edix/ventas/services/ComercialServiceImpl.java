package com.edix.ventas.services;

import com.edix.ventas.model.entitybeans.Comercial;
import com.edix.ventas.model.entitybeans.Pedido;
import com.edix.ventas.reposirory.ComercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComercialServiceImpl implements ComercialService{

    @Autowired
    private ComercialRepository cRepo;

    @Override
    public Comercial findById(int idComercial) {
        return cRepo.findById(idComercial).orElse(null);
    }

    @Override
    public int insertarUno(Comercial comercial) {
        int filas = 0;
        try {
            cRepo.save(comercial); filas = 1;
        }catch(Exception e) { e.printStackTrace();
        }
        return filas;
    }

    @Override
    public int modificarUno(Comercial comercial) {
        int filas = 0;
        try {
            cRepo.save(comercial); filas = 1;
        }catch(Exception e) { e.printStackTrace();
        }
        return filas;
    }

    @Override
    public int eliminarUno(int idComercial) {
        int filas = 0;
        try {
            cRepo.deleteById(idComercial);; filas = 1;
        }catch(Exception e) { e.printStackTrace();
        }
        return filas;
    }

    @Override
    public List<Comercial> buscarPorCliente(int idCliente) {
        return null;
    }

    @Override
    public List<Comercial> buscarPorPedidos() {
        return cRepo.conPedidos();
    }

    @Override
    public List<Pedido> buscarPedPorComer(int idComercial) {
        return null;
    }

}
