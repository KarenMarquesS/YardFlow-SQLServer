package org.example.yardflow.DTO;

import org.example.yardflow.model.Moto;
import org.example.yardflow.model.RegistroCheckInOut;
import org.example.yardflow.model.Vaga;

import java.time.LocalDate;

public class RegistroCheckInOutDTO {

    private int idRegistro;
    private LocalDate entradaPatio;
    private LocalDate saidaPatio;
    private Vaga vaga;
    private Moto idMoto;

    public RegistroCheckInOutDTO() {
    }

    public RegistroCheckInOutDTO(int idRegistro, Vaga vaga, Moto idMoto, LocalDate entradaPatio, LocalDate saidaPatio) {
        this.idRegistro = idRegistro;
        this.vaga = vaga;
        this.idMoto = idMoto;
        this.entradaPatio = entradaPatio;
        this.saidaPatio = saidaPatio;
    }

    public RegistroCheckInOutDTO(RegistroCheckInOut registro) {
        this.idRegistro = registro.getIdRegistro();
        this.entradaPatio = registro.getEntradaPatio();
        this.saidaPatio = registro.getSaidaPatio();
        this.vaga = registro.getVaga();
        this.idMoto = registro.getIdMoto();
    }

    public static RegistroCheckInOutDTO fromPeriodo(LocalDate entrada, LocalDate saida) {
        RegistroCheckInOutDTO regInOut = new RegistroCheckInOutDTO();
        regInOut.setEntradaPatio(entrada);
        regInOut.setSaidaPatio(saida);
        return regInOut;
    }


    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public LocalDate getEntradaPatio() {
        return entradaPatio;
    }

    public void setEntradaPatio(LocalDate entradaPatio) {
        this.entradaPatio = entradaPatio;
    }

    public LocalDate getSaidaPatio() {
        return saidaPatio;
    }

    public void setSaidaPatio(LocalDate saidaPatio) {
        this.saidaPatio = saidaPatio;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Moto getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(Moto idMoto) {
        this.idMoto = idMoto;
    }
}
