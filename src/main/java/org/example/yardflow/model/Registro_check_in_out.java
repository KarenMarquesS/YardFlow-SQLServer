package org.example.yardflow.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;



@Data
@Entity
@Table
public class Registro_check_in_out {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_registro;

    private LocalDate entrada_patio;

    private LocalDate saida_patio;

    @Column(nullable = false)
    private int periodo;

    @ManyToOne
    @JoinColumn(name = "id_vaga")
    private Vaga vaga;

    @ManyToOne
    @JoinColumn(name="id_moto")
    private Moto moto;


    // irá retornar Zero se a entrada e saida for no mesmo dia
    public void calcularPeriodoPermanencia() {
        if (entrada_patio != null) {
            LocalDate dataSaida = (saida_patio != null) ? saida_patio : LocalDate.now();
            long dias = ChronoUnit.DAYS.between(entrada_patio, dataSaida);
            this.periodo = (int) (dias <= 0 ? 1 : dias); // mínimo de 1 dia
        } else {
            this.periodo = 0;
        }
    }

}
