package org.example.yardflow.dto;

import org.example.yardflow.model.EnumModelo;

import java.time.LocalDate;

public class RegistroPermanenciaDTO {

    private int idpermanencia;
    private int idmoto;
    private EnumModelo modelo;
    private LocalDate entradapatio;
    private LocalDate saidapatio;
    private int periodo;

    public RegistroPermanenciaDTO() {
    }

    public RegistroPermanenciaDTO(int idpermanencia, int idmoto, EnumModelo modelo, LocalDate entradapatio, LocalDate saidapatio, int periodo) {
        this.idpermanencia = idpermanencia;
        this.idmoto = idmoto;
        this.modelo = modelo;
        this.entradapatio = entradapatio;
        this.saidapatio = saidapatio;
        this.periodo = periodo;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public LocalDate getSaidapatio() {
        return saidapatio;
    }

    public void setSaidapatio(LocalDate saidapatio) {
        this.saidapatio = saidapatio;
    }

    public LocalDate getEntradapatio() {
        return entradapatio;
    }

    public void setEntradapatio(LocalDate entradapatio) {
        this.entradapatio = entradapatio;
    }

    public EnumModelo getModelo() {
        return modelo;
    }

    public void setModelo(EnumModelo modelo) {
        this.modelo = modelo;
    }

    public int getIdmoto() {
        return idmoto;
    }

    public void setIdmoto(int idmoto) {
        this.idmoto = idmoto;
    }

    public int getIdpermanencia() {
        return idpermanencia;
    }

    public void setIdpermanencia(int idpermanencia) {
        this.idpermanencia = idpermanencia;
    }
}
