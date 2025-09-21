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


@Entity
@Table(name = "tb_yf_registro_check_in_out")
public class Registro_check_in_out {

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

    @Enumerated(EnumType.STRING)
    private EnumSetor setor;

    @Valid
    @ManyToOne
    @JoinColumn(name="id_moto")
    private Moto moto;



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

    public Registro_check_in_out() {
    }

    public Registro_check_in_out(int id_registro, LocalDate entrada_patio, LocalDate saida_patio, int periodo, EnumSetor setor, Moto moto) {
        this.id_registro = id_registro;
        this.entrada_patio = entrada_patio;
        this.saida_patio = saida_patio;
        this.periodo = periodo;
        this.setor = setor;
        this.moto = moto;
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public @Past(message = "Data de Entrada inválida!") LocalDate getEntrada_patio() {
        return entrada_patio;
    }

    public void setEntrada_patio(@Past(message = "Data de Entrada inválida!") LocalDate entrada_patio) {
        this.entrada_patio = entrada_patio;
    }

    public LocalDate getSaida_patio() {
        return saida_patio;
    }

    public void setSaida_patio(LocalDate saida_patio) {
        this.saida_patio = saida_patio;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public EnumSetor getSetor() {
        return setor;
    }

    public void setSetor(EnumSetor setor) {
        this.setor = setor;
    }

    public @Valid Moto getMoto() {
        return moto;
    }

    public void setMoto(@Valid Moto moto) {
        this.moto = moto;
    }
}
