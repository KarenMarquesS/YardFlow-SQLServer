package org.example.yardflow.DTO;

import org.example.parkflow.model.SetorEnum;

public class VagaDTO {

    private String idVaga;
    private boolean ocupada;
    private SetorEnum setor;

    public VagaDTO() {
    }

    public VagaDTO(String idVaga, boolean ocupada, SetorEnum setor) {
        this.idVaga = idVaga;
        this.ocupada = ocupada;
        this.setor = setor;
    }

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
}
