package org.example.yardflow.dto;

import org.example.yardflow.model.EnumModelo;

import java.time.LocalDate;

public class RegistroPermanenciaDTO {

    private int id_permanencia;
    private int id_moto;
    private EnumModelo modelo;
    private LocalDate entrada_patio;
    private LocalDate saida_patio;
    private int periodo;

    public RegistroPermanenciaDTO() {
    }

    public RegistroPermanenciaDTO(int id_permanencia, int id_moto, EnumModelo modelo, LocalDate entrada_patio, LocalDate saida_patio, int periodo) {
        this.id_permanencia = id_permanencia;
        this.id_moto = id_moto;
        this.modelo = modelo;
        this.entrada_patio = entrada_patio;
        this.saida_patio = saida_patio;
        this.periodo = periodo;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public LocalDate getSaida_patio() {
        return saida_patio;
    }

    public void setSaida_patio(LocalDate saida_patio) {
        this.saida_patio = saida_patio;
    }

    public LocalDate getEntrada_patio() {
        return entrada_patio;
    }

    public void setEntrada_patio(LocalDate entrada_patio) {
        this.entrada_patio = entrada_patio;
    }

    public EnumModelo getModelo() {
        return modelo;
    }

    public void setModelo(EnumModelo modelo) {
        this.modelo = modelo;
    }

    public int getId_moto() {
        return id_moto;
    }

    public void setId_moto(int id_moto) {
        this.id_moto = id_moto;
    }

    public int getId_permanencia() {
        return id_permanencia;
    }

    public void setId_permanencia(int id_permanencia) {
        this.id_permanencia = id_permanencia;
    }
}
