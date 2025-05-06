package org.example.yardflow.repository;

import org.example.yardflow.DTO.RegistroCheckIn_OutDTO;
import org.example.yardflow.model.RegistroCheckIn_Out;
import org.springframework.data.jpa.repository.Query;

public interface RegistroCheckIn_OutRepositorio {

    // Consulta feita a partir da data de entrada para localizar o Id da Moto
    @Query("from RegistroCheckIn_Out rG where rG.entradaPatio = :entradaPatio")
    public RegistroCheckIn_Out findByDataEntradaMoto(RegistroCheckIn_Out idMoto);

    // Consulta feita a partir da data de saida para localizar o Id da Moto
    @Query("from RegistroCheckIn_Out rG where rG.saidaPatio = :saidaPatio")
    public RegistroCheckIn_Out findByDataSaidaMoto(RegistroCheckIn_Out idMoto);
}
