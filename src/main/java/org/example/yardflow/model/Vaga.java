package org.example.yardflow.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Entity
@Table
public class Vaga {

    @Id
    private int id_vaga;

    private boolean ocupada;

    @Enumerated(EnumType.STRING)
    private SetorEnum setor;

    @ManyToOne
    @JoinColumn(name = "id_patio")
    private Patio patio;

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL)
    private List<Registro_check_in_out> registrosCheckInOut;

}

