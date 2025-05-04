package org.example.yardflow.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


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

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL)
    private List<RegistroCheckIn_Out> registrosCheckInOut = new ArrayList<>();

}

