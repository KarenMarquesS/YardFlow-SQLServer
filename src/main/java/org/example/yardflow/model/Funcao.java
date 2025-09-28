package org.example.yardflow.model;

import jakarta.persistence.*;


@Entity
@Table(name="tb_yf_funcao")
public class Funcao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfuncao")
    private long idfuncao;

    @Enumerated(EnumType.STRING)
    private EnumFuncao nome;

    public Funcao() {
    }

    public Funcao(long idfuncao, EnumFuncao nome) {
        this.idfuncao = idfuncao;
        this.nome = nome;
    }

    public long getIdfuncao() {
        return idfuncao;
    }

    public void setIdfuncao(long idfuncao) {
        this.idfuncao = idfuncao;
    }

    public EnumFuncao getNome() {
        return nome;
    }

    public void setNome(EnumFuncao nome) {
        this.nome = nome;
    }
}
