package org.example.yardflow.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name="tb_yf_funcao")
public class Funcao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumFuncao nome;

    public Funcao() {
    }

    public Funcao(Long id, EnumFuncao nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumFuncao getNome() {
        return nome;
    }

    public void setNome(EnumFuncao nome) {
        this.nome = nome;
    }
}
