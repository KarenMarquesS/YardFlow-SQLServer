package org.example.yardflow.repository;

import org.example.yardflow.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MotoRepositorio extends JpaRepository<Moto, Integer> {

    // pesquisa com base na placa
    @Query("from Moto mT where mT.placa = :placa")
    public Moto findByPlaca(String placa);

    // aqui irá localizar a moto com o numero do id_moto -> QRcode
    @Query("from Moto mT where mT.id_moto = :id_moto")
    public Moto findByIdMoto(int id_moto);

    @Query("from Moto mT where mT.chassi = :chassi")
    public Moto findByChassi(String chassi);

    @Query("from Moto mT where mT.historico = :id_moto")
    public Moto mostrarHistoricoMoto(int id_moto);



}
