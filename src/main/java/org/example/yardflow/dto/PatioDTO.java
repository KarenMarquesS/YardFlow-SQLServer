package org.example.yardflow.dto;

import org.example.yardflow.model.Patio;
import org.example.yardflow.model.SetorEnum;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PatioDTO {

    private int idPatio;
    private String endereco;
    private int qtdVagas;
    private SetorEnum setor;
    private List<VagaDTO> vagas;


    public PatioDTO(int idPatio, int qtdVagas, String endereco, SetorEnum setor, List<VagaDTO> vagaDTO) {
    }

    public PatioDTO(int idPatio, String endereco, int qtdVagas, SetorEnum setor, List<VagaDTO> vagas) {
        this.idPatio = idPatio;
        this.endereco = endereco;
        this.qtdVagas = qtdVagas;
        this.setor = setor;
        this.vagas = vagas;
    }

    public PatioDTO(Patio p) {
        setIdPatio(p.getIdPatio());
        setEndereco(p.getEndereco());
        setSetor(p.getSetor());
        setQtdVagas(p.getQtdVagas());
        setVagas(Optional.ofNullable(p.getVagas()).orElse(Collections.emptyList()).stream().map(VagaDTO::new).collect(Collectors.toList()));
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

    public List<VagaDTO> getVagas() {
        return vagas;
    }

    public void setVagas(List<VagaDTO> vagas) {
        this.vagas = vagas;
    }
}
