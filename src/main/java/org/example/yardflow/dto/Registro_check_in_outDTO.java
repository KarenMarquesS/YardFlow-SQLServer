package org.example.yardflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.yardflow.model.Registro_check_in_out;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registro_check_in_outDTO {

    private int id_registro;
    private LocalDate entrada_patio;
    private LocalDate saida_patio;
    private int periodo;
    private MotoDTO motoDTO;

    public Registro_check_in_outDTO(Registro_check_in_out registro) {
        this.id_registro = registro.getId_registro();
        this.entrada_patio = registro.getEntrada_patio();
        this.saida_patio = registro.getSaida_patio();
        this.periodo = registro.getPeriodo();
        this.motoDTO = new MotoDTO();

        // sobre a entidade moto
        var m = registro.getMoto();
        this.motoDTO = new MotoDTO(
                registro.getMoto().getId_moto(),
                registro.getMoto().getModelo(),
                registro.getMoto().getChassi(),
                registro.getMoto().getPlaca(),
                registro.getMoto().getHistorico(),
                registro.getMoto().getYfIoT()
        );
    }
}
