package org.example.yardflow.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registro_chack_in_out")
public class RegistroCheckInOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_registro;

    @Past(message = "Data de Entrada inválida!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate entrada_patio;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate saida_patio;

    @Column(nullable = false)
    private int periodo;

    @Valid
    @ManyToOne
    @JoinColumn(name="id_moto")
    private Moto moto;

    @Valid
    @ManyToOne
    @JoinColumn(name = "id_vaga", nullable = false)
    private Vaga vaga;


    // irá retornar Zero se a entrada e saida for no mesmo dia
    public void calcularPeriodoPermanencia() {
        if (entrada_patio == null) {
            throw new IllegalStateException("A data de entrada deve ser informada.");
        }

        LocalDate dataSaida = (saida_patio != null) ? saida_patio : LocalDate.now();

        if (dataSaida.isBefore(entrada_patio)) {
            throw new IllegalArgumentException("A data de saída não pode ser anterior à data de entrada.");
        }

        long dias = ChronoUnit.DAYS.between(entrada_patio, dataSaida);
        this.periodo = (int) Math.max(dias, 1 ); // mínimo 1 dia
    }
}
