package org.example.yardflow.DTO;


import org.example.yardflow.model.SetorEnum;
import org.example.yardflow.model.Vaga;

public class VagaDTO {

    private String idVaga;
    private SetorEnum setor;
    private boolean ocupada;


    public VagaDTO() {
    }

    public VagaDTO(String idVaga,  SetorEnum setor, boolean ocupada) {
        this.idVaga = idVaga;
        this.setor = setor;
        this.ocupada = ocupada;
    }

    public VagaDTO(Vaga vaga){
       setIdVaga(vaga.getIdVaga());
       setOcupada(vaga.isOcupada());
       setSetor(vaga.getSetor());
    }

    public String getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(String idVaga) {
        this.idVaga = idVaga;
    }

    public SetorEnum getSetor() {
        return setor;
    }

    public void setSetor(SetorEnum setor) {
        this.setor = setor;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
