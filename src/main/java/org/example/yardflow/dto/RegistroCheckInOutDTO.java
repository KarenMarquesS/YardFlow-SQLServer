package org.example.yardflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.yardflow.model.RegistroCheckInOut;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroCheckInOutDTO {

    private int id_registro;
    private LocalDate entrada_patio;
    private LocalDate saida_patio;
    private VagaDTO vaga;
    private MotoDTO moto;

    public RegistroCheckInOutDTO(RegistroCheckInOut registro) {
        this.id_registro = registro.getId_registro();
        this.entrada_patio = registro.getEntrada_patio();
        this.saida_patio = registro.getSaida_patio();
        this.vaga = new VagaDTO(registro.getVaga());

        var m = registro.getMoto();
        this.moto = new MotoDTO(
                registro.getMoto().getId_moto(),
                registro.getMoto().getModelo(),
                registro.getMoto().getChassi(),
                registro.getMoto().getPlaca(),
                registro.getMoto().getHistorico(),
                registro.getMoto().isAtivo(),
                registro.getMoto().getYFlowIoT()
        );
    }
}
