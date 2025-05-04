package org.example.yardflow.DTO;

import org.example.parkflow.model.Cliente;
import org.example.parkflow.model.ModeloEnum;

import java.time.LocalDate;

public class MotoDTO {

    private long idMoto;
    private ModeloEnum modelo;
    private LocalDate ano_fabricacao;
    private String chassi;
    private String n_motor;
    private String placa;
    private String historico;
    private Cliente cliente;


    public MotoDTO() {
    }

    public MotoDTO(long idMoto, ModeloEnum modelo, LocalDate ano_fabricacao, String chassi, String n_motor, String placa, String historico, Cliente cliente) {
        this.idMoto = idMoto;
        this.modelo = modelo;
        this.ano_fabricacao = ano_fabricacao;
        this.chassi = chassi;
        this.n_motor = n_motor;
        this.placa = placa;
        this.historico = historico;
        this.cliente = cliente;
    }

    public long getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(long idMoto) {
        this.idMoto = idMoto;
    }

    public ModeloEnum getModelo() {
        return modelo;
    }

    public void setModelo(ModeloEnum modelo) {
        this.modelo = modelo;
    }

    public LocalDate getAno_fabricacao() {
        return ano_fabricacao;
    }

    public void setAno_fabricacao(LocalDate ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getN_motor() {
        return n_motor;
    }

    public void setN_motor(String n_motor) {
        this.n_motor = n_motor;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}