package org.example.yardflow.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;



@Data
@Entity
@Table
public class Patio {

    @Id
    private int idPatio;

    private String endereco;

    private int qtdVagas;

    @Enumerated(EnumType.STRING)
    private SetorEnum setor;

    @OneToMany(mappedBy = "patio", cascade = CascadeType.ALL)
    private List<Vaga> vagas;


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

