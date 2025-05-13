package org.example.yardflow.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Entity
@Table
public class Vaga {

    @Id
    private String idVaga;

    private boolean ocupada;

    @Enumerated(EnumType.STRING)
    private SetorEnum setor;

    @ManyToOne
    @JoinColumn(name = "idPatio")
    private Patio patio;

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL)
    private List<RegistroCheckInOut> registrosCheckInOut;


    public String getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(String idVaga) {
        this.idVaga = idVaga;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public SetorEnum getSetor() {
        return setor;
    }

    public void setSetor(SetorEnum setor) {
        this.setor = setor;
    }

    public Patio getPatio() {
        return patio;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    public List<RegistroCheckInOut> getRegistrosCheckInOut() {
        return registrosCheckInOut;
    }

    public void setRegistrosCheckInOut(List<RegistroCheckInOut> registrosCheckInOut) {
        this.registrosCheckInOut = registrosCheckInOut;
    }
}

