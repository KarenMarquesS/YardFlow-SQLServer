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
    private int id_patio;

    private String endereco;

    private int qtd_vagas;

    @Enumerated(EnumType.STRING)
    private SetorEnum setor;

    @OneToMany(mappedBy = "patio", cascade = CascadeType.ALL)
    private List<Vaga> vaga;

}

