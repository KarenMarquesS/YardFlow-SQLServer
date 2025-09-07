package org.example.yardflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.yardflow.model.EnumModelo;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotoDTO {

    private int id_moto;

    private EnumModelo modelo;

    @Size(min = 17, max = 17, message = "Chassi deve ter 17 caracteres")
    private String chassi;

    @Size(min = 6, max = 7, message = "Placa deverá ter 7 caracteres")
    @Pattern(regexp = "^[A-Z]{3}[0-9][0-9A-Z][0-9]{2}$", message = "Placa inválida. Use o formato ABC1D23.")
    private String placa;

    @NotBlank(message = "Registre o motivo da moto entrar no pátio, 400 caracteres")
    @Size(min = 200, max = 500, message = "Registre o motivo")
    private String historico;

    private boolean ativo;
    private int yFlowIoT;


}