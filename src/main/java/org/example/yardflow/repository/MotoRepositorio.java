package org.example.yardflow.repository;

import org.example.yardflow.model.Moto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepositorio extends JpaRepository<Moto, Long> {

    Moto findByPlaca(String placa);

    Moto findByChassi(String chassi);

    @Query("select mT.historico from Moto mT where mT.idmoto = :idmoto")
    String historicoMoto(@Param("idmoto") long idmoto);
    
    @Query("SELECT mT FROM Moto mT LEFT JOIN FETCH mT.yardflow ORDER BY mT.idmoto")
    Page<Moto> findAllWithYardflow(Pageable pageable);


}
