package org.example.yardflow.model;

import jakarta.persistence.*;


@Entity
@Table(name="tb_yf_funcao")
public class Funcao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_funcao;

    @Enumerated(EnumType.STRING)
    private EnumFuncao nome;

    public Funcao() {
    }

    public Funcao(Long id_funcao, EnumFuncao nome) {
        this.id_funcao = id_funcao;
        this.nome = nome;
    }

    public Long getId() {
        return id_funcao;
    }

    public void setId(Long id_funcao) {
        this.id_funcao = id_funcao;
    }

    public EnumFuncao getNome() {
        return nome;
    }

    public void setNome(EnumFuncao nome) {
        this.nome = nome;
    }
}
