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

    // aqui irá localizar a moto com o numero do idMoto -> QRcode
    @Query("from Moto mT where mT.idMoto = :idMoto")
    public Moto findByIdMoto(int idMoto);

    @Query("from Moto mT where mT.chassi = :chassi")
    public Moto findByChassi(String chassi);

    @Query("from Moto mT where mT.historico = :idMoto")
    public Moto mostrarHistoricoMoto(int idMoto);



}
