package org.example.yardflow.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Vaga {

    @Id
    private String idVaga;

    private boolean ocupada;

    @Enumerated(EnumType.STRING)
    private SetorEnum setor;

    @ManyToOne
    @JoinColumn(name = "idPatio")
    private Patio patio;


}

