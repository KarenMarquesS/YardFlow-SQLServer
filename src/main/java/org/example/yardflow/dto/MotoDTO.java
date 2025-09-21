package org.example.yardflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

import org.example.yardflow.model.EnumModelo;
import org.example.yardflow.model.Yardflow;



public class MotoDTO {

    private int id_moto;

    private EnumModelo modelo;

    @Size(min = 17, max = 17, message = "Chassi deve ter 17 caracteres")
    private String chassi;

    @Size(min = 6, max = 7, message = "Placa deverá ter 7 caracteres")
    @Pattern(regexp = "^[A-Z]{3}[0-9][0-9A-Z][0-9]{2}$", message = "Placa inválida. Use o formato ABC1D23.")
    private String placa;

    @NotBlank(message = "Registre o motivo da moto entrar no pátio, 500 caracteres")
    @Size(min = 200, max = 500, message = "Registre o motivo")
    private String historico;

    private Yardflow yardflow;


    public MotoDTO() {
    }

    public MotoDTO(int id_moto, EnumModelo modelo, String chassi, String placa, String historico, Yardflow yardflow) {
        this.id_moto = id_moto;
        this.modelo = modelo;
        this.chassi = chassi;
        this.placa = placa;
        this.historico = historico;
        this.yardflow = yardflow;
    }

    public int getId_moto() {
        return id_moto;
    }

    public void setId_moto(int id_moto) {
        this.id_moto = id_moto;
    }

    public EnumModelo getModelo() {
        return modelo;
    }

    public void setModelo(EnumModelo modelo) {
        this.modelo = modelo;
    }

    public @Size(min = 17, max = 17, message = "Chassi deve ter 17 caracteres") String getChassi() {
        return chassi;
    }

    public void setChassi(@Size(min = 17, max = 17, message = "Chassi deve ter 17 caracteres") String chassi) {
        this.chassi = chassi;
    }

    public @Size(min = 6, max = 7, message = "Placa deverá ter 7 caracteres") @Pattern(regexp = "^[A-Z]{3}[0-9][0-9A-Z][0-9]{2}$", message = "Placa inválida. Use o formato ABC1D23.") String getPlaca() {
        return placa;
    }

    public void setPlaca(@Size(min = 6, max = 7, message = "Placa deverá ter 7 caracteres") @Pattern(regexp = "^[A-Z]{3}[0-9][0-9A-Z][0-9]{2}$", message = "Placa inválida. Use o formato ABC1D23.") String placa) {
        this.placa = placa;
    }

    public @NotBlank(message = "Registre o motivo da moto entrar no pátio, 500 caracteres") @Size(min = 200, max = 500, message = "Registre o motivo") String getHistorico() {
        return historico;
    }

    public void setHistorico(@NotBlank(message = "Registre o motivo da moto entrar no pátio, 500 caracteres") @Size(min = 200, max = 500, message = "Registre o motivo") String historico) {
        this.historico = historico;
    }

    public Yardflow getYardflow() {
        return yardflow;
    }

    public void setYardflow(Yardflow yardflow) {
        this.yardflow = yardflow;
    }
}