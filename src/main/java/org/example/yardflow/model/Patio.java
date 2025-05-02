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
    private long idPatio;

    private LocalDate entrada_patio;

    private LocalDate saida_patio;

    @Enumerated(EnumType.STRING)
    private SetorEnum setor;

    @OneToMany(mappedBy = "patio", cascade = CascadeType.ALL)
    private List<Vaga> vagas;

}

