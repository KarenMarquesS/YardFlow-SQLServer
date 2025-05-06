package org.example.yardflow.DTO;

import org.example.yardflow.model.SetorEnum;
import org.example.yardflow.model.Vaga;

import java.util.List;

public class PatioDTO {

    private int idPatio;
    private String endereco;
    private int qtdVagas;
    private SetorEnum setor;
    private List<Vaga> vagas;


    public PatioDTO() {
    }


    public PatioDTO(int idPatio, int qtdVagas, String endereco, SetorEnum setor, List<Vaga> vagas) {
        this.idPatio = idPatio;
        this.qtdVagas = qtdVagas;
        this.endereco = endereco;
        this.setor = setor;
        this.vagas = vagas;
    }

    public PatioDTO(PatioDTO p) {
        setIdPatio(p.getIdPatio());
        setEndereco(p.getEndereco());
        setQtdVagas(p.getQtdVagas());
        setVagas(p.getVagas());
    }



    public int getIdPatio() {
        return idPatio;
    }

    public void setIdPatio(int idPatio) {
        this.idPatio = idPatio;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }

    public void setQtdVagas(int qtdVagas) {
        this.qtdVagas = qtdVagas;
    }

    public SetorEnum getSetor() {
        return setor;
    }

    public void setSetor(SetorEnum setor) {
        this.setor = setor;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }
}
