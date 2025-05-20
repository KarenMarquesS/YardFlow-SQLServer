package org.example.yardflow.dto;

import org.example.yardflow.model.Patio;
import org.example.yardflow.model.SetorEnum;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PatioDTO {

    private int id_patio;
    private String endereco;
    private int qtd_vagas;
    private SetorEnum setor;
    private List<VagaDTO> vaga;


    public PatioDTO(int id_patio, int qtd_vagas, String endereco, SetorEnum setor, List<VagaDTO> vagaDTO) {
    }

    public PatioDTO(int id_patio, String endereco, int qtd_vagas, SetorEnum setor, List<VagaDTO> vaga) {
        this.id_patio = id_patio;
        this.endereco = endereco;
        this.qtd_vagas = qtd_vagas;
        this.setor = setor;
        this.vaga = vaga;
    }

    public PatioDTO(Patio p) {
        setIdPatio(p.getId_patio());
        setEndereco(p.getEndereco());
        setSetor(p.getSetor());
        setQtdVagas(p.getQtd_vagas());
        setVagas(Optional.ofNullable(p.getVaga()).orElse(Collections.emptyList()).stream().map(VagaDTO::new).collect(Collectors.toList()));
    }



    public int getIdPatio() {
        return id_patio;
    }

    public void setIdPatio(int id_patio) {
        this.id_patio = id_patio;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getQtd_vagas() {
        return qtd_vagas;
    }

    public void setQtdVagas(int qtd_vagas) {
        this.qtd_vagas = qtd_vagas;
    }

    public SetorEnum getSetor() {
        return setor;
    }

    public void setSetor(SetorEnum setor) {
        this.setor = setor;
    }

    public List<VagaDTO> getVaga() {
        return vaga;
    }

    public void setVagas(List<VagaDTO> vaga) {
        this.vaga = vaga;
    }
}
