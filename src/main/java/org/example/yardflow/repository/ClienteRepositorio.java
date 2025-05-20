package org.example.yardflow.repository;

import org.example.yardflow.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

    @Query("from Cliente cl where cl.id_cliente = :id_cliente")
    public Cliente mostrarCliente(@Param("id_cliente") int id_cliente);

    @Query("select cl from Cliente cl join cl.id_moto mt where mt.id_moto = :id_moto")
    public Cliente buscarPorIdMoto(@Param("id_moto")int id_moto);
}
