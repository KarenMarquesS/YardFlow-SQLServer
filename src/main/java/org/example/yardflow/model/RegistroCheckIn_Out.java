package org.example.yardflow.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table
public class RegistroCheckIn_Out {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRegistro;

    private LocalDate entradaPatio;

    private LocalDate saidaPatio;

    @OneToMany
    @JoinColumn(name = "idVaga")
    private Vaga vaga;

    @OneToMany
    @JoinColumn(name="idMoto")
    private Moto idMoto;

}
