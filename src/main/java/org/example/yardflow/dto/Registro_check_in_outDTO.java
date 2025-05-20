package org.example.yardflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.example.yardflow.model.Moto;
import org.example.yardflow.model.Registro_check_in_out;
import org.example.yardflow.model.Vaga;

import java.time.LocalDate;

public class Registro_check_in_outDTO {

    private int id_registro;

    @PastOrPresent(message = "A data de entrada não pode ser futura")
    private LocalDate entrada_patio;

    @PastOrPresent(message = "A data de saída não pode ser futura")
    private LocalDate saida_patio;
    private Vaga vaga;
    private Moto moto;

    public Registro_check_in_outDTO() {
    }

    public Registro_check_in_outDTO(int id_registro, Vaga vaga, Moto moto, LocalDate entrada_patio, LocalDate saida_patio) {
        this.id_registro = id_registro;
        this.vaga = vaga;
        this.moto = moto;
        this.entrada_patio = entrada_patio;
        this.saida_patio = saida_patio;
    }

    public Registro_check_in_outDTO(Registro_check_in_out registro) {
        this.id_registro = registro.getId_registro();
        this.entrada_patio = registro.getEntrada_patio();
        this.saida_patio = registro.getSaida_patio();
        this.vaga = registro.getVaga();
        this.moto = registro.getMoto();
    }

    public static Registro_check_in_outDTO fromPeriodo(LocalDate entrada, LocalDate saida) {
        Registro_check_in_outDTO regInOut = new Registro_check_in_outDTO();
        regInOut.setEntrada_patio(entrada);
        regInOut.setSaidaPatio(saida);
        return regInOut;
    }


    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public LocalDate getEntrada_patio() {
        return entrada_patio;
    }

    public void setEntrada_patio(LocalDate entrada_patio) {
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

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }
}
