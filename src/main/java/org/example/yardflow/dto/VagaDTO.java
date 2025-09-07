package org.example.yardflow.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.example.yardflow.model.EnumSetor;
import org.example.yardflow.model.Patio;
import org.example.yardflow.model.Vaga;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VagaDTO {

    private int id_vaga;
    private EnumSetor setor;
    private boolean ocupada;
    private int id_patio;
    private List<RegistroCheckInOutDTO> registros;



    public VagaDTO(Vaga vaga) {
       this.id_vaga = vaga.getId_vaga();
       this.ocupada = vaga.isOcupada();
       this.setor = vaga.getSetor();
       this.id_patio = vaga.getPatio() != null ? vaga.getPatio().getId_patio() : null;
       this.registros = Optional.ofNullable(vaga.getRegistrosCheckInOut())
                .orElse(Collections.emptyList())
                .stream()
                .map(RegistroCheckInOutDTO::new)
                .collect(Collectors.toList());

    }

}
