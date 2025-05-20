package org.example.yardflow.dto;

import org.example.yardflow.model.Moto;
import org.example.yardflow.model.Registro_check_in_out;
import org.example.yardflow.model.Vaga;

import java.time.LocalDate;

public class Registro_check_in_outDTO {

    private int id_registro;
    private LocalDate entrada_patio;
    private LocalDate saida_patio;
    private Vaga vaga;
    private Moto id_moto;

    public Registro_check_in_outDTO() {
    }

    public Registro_check_in_outDTO(int id_registro, Vaga vaga, Moto id_moto, LocalDate entrada_patio, LocalDate saida_patio) {
        this.id_registro = id_registro;
        this.vaga = vaga;
        this.id_moto = id_moto;
        this.entrada_patio = entrada_patio;
        this.saida_patio = saida_patio;
    }

    public Registro_check_in_outDTO(Registro_check_in_out registro) {
        this.id_registro = registro.getId_registro();
        this.entrada_patio = registro.getEntrada_patio();
        this.saida_patio = registro.getSaida_patio();
        this.vaga = registro.getVaga();
        this.id_moto = registro.getMoto();
    }

    public static Registro_check_in_outDTO fromPeriodo(LocalDate entrada, LocalDate saida) {
        Registro_check_in_outDTO regInOut = new Registro_check_in_outDTO();
        regInOut.setEntradaPatio(entrada);
        regInOut.setSaidaPatio(saida);
        return regInOut;
    }


    public int getId_registro() {
        return id_registro;
    }

    public void setIdRegistro(int id_registro) {
        this.id_registro = id_registro;
    }

    public LocalDate getEntrada_patio() {
        return entrada_patio;
    }

    public void setEntradaPatio(LocalDate entrada_patio) {
        this.entrada_patio = entrada_patio;
    }

    public LocalDate getSaida_patio() {
        return saida_patio;
    }

    public void setSaidaPatio(LocalDate saida_patio) {
        this.saida_patio = saida_patio;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Moto getId_moto() {
        return id_moto;
    }

    public void setIdMoto(Moto id_moto) {
        this.id_moto = id_moto;
    }
}
