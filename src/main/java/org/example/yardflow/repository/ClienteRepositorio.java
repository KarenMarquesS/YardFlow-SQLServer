package org.example.yardflow.repository;

import org.example.yardflow.model.Cliente;
import org.example.yardflow.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {


    @Query("select mt from Moto mt where mt.cliente.id_cliente = :id_cliente")
    public Moto buscarMotoPorIdCliente(@Param("id_cliente") int id_cliente);
}
