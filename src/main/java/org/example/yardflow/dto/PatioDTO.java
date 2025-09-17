package org.example.yardflow.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.example.yardflow.model.Patio;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatioDTO {

    private int id_patio;

    private String nickname;

    @NotBlank
    @Size(min = 2, max = 200)
    private String endereco;

    @Positive
    private int qtd_vagas;


    // Conversão de entidade em DTO
    public PatioDTO(Patio p) {
        this.id_patio = p.getId_patio();
        this.endereco = p.getEndereco();
        this.qtd_vagas = p.getQtd_vagas();


    }

}
