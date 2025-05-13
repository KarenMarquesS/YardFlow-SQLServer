package org.example.yardflow.DTO;

import org.example.yardflow.model.Cliente;

public class MotoDTO {

    private int idMoto;
    private String chassi;
    private String placa;
    private String historico;
    private boolean ativo;
    private Cliente cliente;



    public MotoDTO() {
    }

    public MotoDTO(int idMoto, String chassi, String placa, String historico, boolean ativo, Cliente cliente) {
        this.idMoto = idMoto;
        this.chassi = chassi;
        this.placa = placa;
        this.historico = historico;
        this.ativo = ativo;
        this.cliente = cliente;
    }

    public MotoDTO(int idMoto, String chassi,  String placa) {
        this.idMoto = idMoto;
        this.chassi = chassi;
        this.placa = placa;
    }

    public MotoDTO(int idMoto, String historico) {
        this.idMoto = idMoto;
        this.historico = historico;
    }

    public MotoDTO(int idMoto, Cliente cliente) {
        this.idMoto = idMoto;
        this.cliente = cliente;
    }

    public MotoDTO(int idMoto, boolean ativo) {
        this.idMoto = idMoto;
        this.ativo = ativo;
    }

    public int getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(int idMoto) {
        this.idMoto = idMoto;
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