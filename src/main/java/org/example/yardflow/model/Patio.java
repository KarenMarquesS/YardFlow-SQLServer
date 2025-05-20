package org.example.yardflow.model;


import jakarta.persistence.*;
import lombok.*;


import java.util.List;



@Data
@Entity
@Table
public class Patio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_patio;

    private String endereco;

    private int qtd_vagas;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private SetorEnum setor;

    @OneToMany(mappedBy = "patio", cascade = CascadeType.ALL)
    private List<Vaga> vaga;

}

