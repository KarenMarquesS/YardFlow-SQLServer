package org.example.yardflow.DTO;

import org.example.yardflow.model.Cliente;

import java.time.LocalDate;

public class MotoDTO {

    private long idMoto;
    private LocalDate anoFabricacao;
    private String chassi;
    private String nMotor;
    private String placa;
    private String historico;
    private boolean ativo;
    private Cliente cliente;



    public MotoDTO() {
    }

    public MotoDTO(long idMoto, LocalDate anoFabricacao, String chassi, String nMotor, String placa, String historico, boolean ativo, Cliente cliente) {
        this.idMoto = idMoto;
        this.anoFabricacao = anoFabricacao;
        this.chassi = chassi;
        this.nMotor = nMotor;
        this.placa = placa;
        this.historico = historico;
        this.ativo = ativo;
        this.cliente = cliente;
    }

    public MotoDTO(long idMoto, String chassi, String nMotor, String placa) {
        this.idMoto = idMoto;
        this.chassi = chassi;
        this.nMotor = nMotor;
        this.placa = placa;
    }

    public MotoDTO(long idMoto, String historico) {
        this.idMoto = idMoto;
        this.historico = historico;
    }

    public MotoDTO(long idMoto, Cliente cliente) {
        this.idMoto = idMoto;
        this.cliente = cliente;
    }

    public MotoDTO(long idMoto, boolean ativo) {
        this.idMoto = idMoto;
        this.ativo = ativo;
    }
}