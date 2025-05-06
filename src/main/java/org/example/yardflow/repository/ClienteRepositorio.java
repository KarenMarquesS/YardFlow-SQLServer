package org.example.yardflow.repository;

import org.example.yardflow.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

    @Query("from Cliente c where c.idCliente = :idCliente")
    public Cliente mostrarCliente(@Param("idCliente") int idCliente);

    @Query("from Cliente c where c.idCliente = :idMoto")
    public Cliente buscarPorIdMoto(@Param("idMoto")int idMoto);
}
