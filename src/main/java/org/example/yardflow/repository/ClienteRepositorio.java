package org.example.yardflow.repository;

import org.example.yardflow.model.Cliente;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepositorio {

    @Query("from Cliente c where c.idCliente = :idCliente")
    public Cliente mostrarCliente(Cliente cliente);

    @Query("from Cliente c where c.idCliente = :idMoto")
    public Cliente buscarPorIdMoto(int idMoto);
}
