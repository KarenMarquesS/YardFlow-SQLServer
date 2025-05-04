package org.example.yardflow.model;


import jakarta.persistence.*;
import lombok.Data;

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

}

