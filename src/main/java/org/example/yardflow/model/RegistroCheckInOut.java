package org.example.yardflow.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;



@Data
@Entity
@Table
public class RegistroCheckInOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRegistro;

    private LocalDate entradaPatio;

    private LocalDate saidaPatio;

    private int periodo;

    @ManyToOne
    @JoinColumn(name = "idVaga")
    private Vaga vaga;

    @ManyToOne
    @JoinColumn(name="idMoto")
    private Moto idMoto;


    // irá retornar Zero se a entrada e saida for no mesmo dia
    public void calcularPeriodoPermanencia(){
        if (entradaPatio != null && saidaPatio != null) {
            long dias = ChronoUnit.DAYS.between(entradaPatio, saidaPatio);
            this.periodo = (int) (dias <= 0 ? 1 : dias ); // considerando o minimo de 1 dia
        }else{
            this.periodo = 0;
        }
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

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
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
