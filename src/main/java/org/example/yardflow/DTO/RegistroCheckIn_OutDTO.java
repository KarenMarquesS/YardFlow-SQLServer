package org.example.yardflow.DTO;

import org.example.yardflow.model.Moto;
import org.example.yardflow.model.Vaga;

import java.time.LocalDate;

public class RegistroCheckIn_OutDTO {

    private int idRegistro;
    private LocalDate entradaPatio;
    private LocalDate saidaPatio;
    private Vaga vaga;
    private Moto idMoto;

    public RegistroCheckIn_OutDTO() {
    }

    public RegistroCheckIn_OutDTO(int idRegistro, Vaga vaga, Moto idMoto, LocalDate entradaPatio, LocalDate saidaPatio) {
        this.idRegistro = idRegistro;
        this.vaga = vaga;
        this.idMoto = idMoto;
        this.entradaPatio = entradaPatio;
        this.saidaPatio = saidaPatio;
    }

    public RegistroCheckIn_OutDTO (RegistroCheckIn_OutDTO reg){
        setIdRegistro(reg.getIdRegistro());
        setVaga(reg.getVaga());
        setIdMoto(reg.getIdMoto());

    }

    public static RegistroCheckIn_OutDTO fromPeriodo(LocalDate entrada, LocalDate saida) {
        RegistroCheckIn_OutDTO regInOut = new RegistroCheckIn_OutDTO();
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
