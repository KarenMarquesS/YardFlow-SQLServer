package org.example.yardflow.repository;

import org.example.yardflow.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepositorio extends JpaRepository<Moto, Integer> {

    Moto findByPlaca(String placa);

    Moto findById(int id_moto);

    Moto findByChassi(String chassi);

    @Query("select mT.historico from Moto mT where mT.id_moto = :id_moto")
    String mostrarHistoricoMoto(@Param("id_moto") int id_moto);

}
