package com.edix.ventas.services;

import com.edix.ventas.model.entitybeans.Comercial;
import com.edix.ventas.model.entitybeans.Pedido;
import com.edix.ventas.repository.ComercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComercialServiceImpl implements ComercialService{

    @Autowired
    private ComercialRepository cRepo;

    @Override
    /**
     * Busca un Comercial en la base de datos por su ID
     * @param idComercial ID del Comercial a buscar
     * @return Comercial si lo encuentra, null si no lo encuentra
     * */
    public Comercial findById(int idComercial) {
        return cRepo.findById(idComercial).orElse(null);
    }

    @Override
    /**
     * Inserta un Comercial en la base de datos
     * @param comercial Comercial a insertar
     * @return 1 si se inserta correctamente, 0 si no se inserta
     */
    public int insertarUno(Comercial comercial) {
        int filas = 0;
        try {
            cRepo.save(comercial); filas = 1;
        }catch(Exception e) { e.printStackTrace();
        }
        return filas;
    }

    @Override
    /**
     * Modifica un Comercial en la base de datos
     * @param comercial Comercial a modificar
     * @return 1 si se modifica correctamente, 0 si no se modifica
     */
    public int modificarUno(Comercial comercial) {
        int filas = 0;
        try {
            cRepo.save(comercial); filas = 1;
        }catch(Exception e) { e.printStackTrace();
        }
        return filas;
    }

    @Override
    /**
     * Elimina un Comercial en la base de datos
     * @param idComercial ID del Comercial a eliminar
     * @return 1 si se elimina correctamente, 0 si no se elimina
     */
    public int eliminarUno(int idComercial) {
        int filas = 0;
        try {
            cRepo.deleteById(idComercial);; filas = 1;
        }catch(Exception e) { e.printStackTrace();
        }
        return filas;
    }

    @Override
    /**
     * Busca los Comerciales que han atendido pedidos del cliente 
     * que coincida con ese id.
     * @param idCliente ID del Cliente
     * @return los Comerciales si los encuentra, null si no los encuentra
     */
    public List<Comercial> buscarPorCliente(int idCliente) {
        return cRepo.porCliente(idCliente);
    }

    @Override
    /**
     * Busca los Comerciales que han atendido pedidos del cliente que coincida con ese id.
     * @param idCliente ID del Cliente
     * @return los Comerciales si los encuentra, null si no los encuentra
     */
    public List<Comercial> buscarPorPedidos() {
        return cRepo.conPedidos();
    }

    @Override
    /**
     * Busca los Pedidos que gestionados por el Comercial que coincida con ese id.
     * @param idComercial ID del Comercial
     * @return los Pedidos si los encuentra, null si no los encuentra
     * */
    public List<Pedido> verPedidos(int idComercial) {
        return cRepo.verPedidos(idComercial);
    }

}
