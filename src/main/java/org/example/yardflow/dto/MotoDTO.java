package org.example.yardflow.dto;

import org.example.yardflow.model.Cliente;

public class MotoDTO {

    private int id_moto;
    private String chassi;
    private String placa;
    private String historico;
    private boolean ativo;
    private Cliente cliente;



    public MotoDTO() {
    }

    public MotoDTO(int id_moto, String chassi, String placa, String historico, boolean ativo, Cliente cliente) {
        this.id_moto = id_moto;
        this.chassi = chassi;
        this.placa = placa;
        this.historico = historico;
        this.ativo = ativo;
        this.cliente = cliente;
    }

    public MotoDTO(int id_moto, String chassi,  String placa) {
        this.id_moto = id_moto;
        this.chassi = chassi;
        this.placa = placa;
    }

    public MotoDTO(int id_moto, String historico) {
        this.id_moto = id_moto;
        this.historico = historico;
    }

    public MotoDTO(int id_moto, Cliente cliente) {
        this.id_moto = id_moto;
        this.cliente = cliente;
    }

    public MotoDTO(int id_moto, boolean ativo) {
        this.id_moto = id_moto;
        this.ativo = ativo;
    }

    public int getIdMoto() {
        return id_moto;
    }

    public void setIdMoto(int id_moto) {
        this.id_moto = id_moto;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}