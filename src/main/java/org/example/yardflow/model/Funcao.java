package org.example.yardflow.model;

import jakarta.persistence.*;


@Entity
@Table(name="tb_yf_funcao")
public class Funcao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfucao;

    @Enumerated(EnumType.STRING)
    private EnumFuncao nome;

    public Funcao() {
    }

    public Funcao(Long idfucao, EnumFuncao nome) {
        this.idfucao = idfucao;
        this.nome = nome;
    }

    public Long getId() {
        return idfucao;
    }

    public void setId(Long idfucao) {
        this.idfucao = idfucao;
    }

    public EnumFuncao getNome() {
        return nome;
    }

    public void setNome(EnumFuncao nome) {
        this.nome = nome;
    }
}
