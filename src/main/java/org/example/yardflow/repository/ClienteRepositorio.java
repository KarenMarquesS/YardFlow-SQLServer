package org.example.yardflow.repository;

import org.example.yardflow.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

    @Query("from Cliente cl where cl.idCliente = :idCliente")
    public Cliente mostrarCliente(@Param("idCliente") int idCliente);

    @Query("select cl from Cliente cl join cl.idMoto mt where mt.idMoto = :idMoto")
    public Cliente buscarPorIdMoto(@Param("idMoto")int idMoto);
}
