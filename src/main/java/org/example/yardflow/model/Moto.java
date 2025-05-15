package org.example.yardflow.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;



@Data
@Entity
@Table
public class Moto {


    @Id
    private int idMoto;

    @Enumerated(EnumType.STRING)
    private ModeloEnum modelo;

    @Column(length = 17)
    private String chassi;

    @Column(length = 7)
    private String placa;

    @Column(length = 1000)
    private String historico;

    @Column(nullable = false)
    private boolean ativo = true;

    @OneToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "idMoto", cascade = CascadeType.ALL)
    private List<RegistroCheckInOut> registrosCheckInOut;


    public int getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(int idMoto) {
        this.idMoto = idMoto;
    }

    public ModeloEnum getModelo() {
        return modelo;
    }

    public void setModelo(ModeloEnum modelo) {
        this.modelo = modelo;
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

    public List<RegistroCheckInOut> getRegistrosCheckInOut() {
        return registrosCheckInOut;
    }

    public void setRegistrosCheckInOut(List<RegistroCheckInOut> registrosCheckInOut) {
        this.registrosCheckInOut = registrosCheckInOut;
    }
}
