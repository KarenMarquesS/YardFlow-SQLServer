package org.example.yardflow.model;

import jakarta.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "tb_yf_IoT")
public class Yardflow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_yf;

    @Column(nullable = false, unique = true)
    private String serial;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dt_ultimo_acionamento;

    @ManyToOne
    private Moto moto;


    public Yardflow() {
    }

    public Yardflow(UUID id_yf, String serial, LocalDate dt_ultimo_acionamento, Moto moto) {
        this.id_yf = id_yf;
        this.serial = serial;
        this.dt_ultimo_acionamento = dt_ultimo_acionamento;
        this.moto = moto;
    }

    public UUID getId_yf() {
        return id_yf;
    }

    public void setId_yf(UUID id_yf) {
        this.id_yf = id_yf;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public LocalDate getDt_ultimo_acionamento() {
        return dt_ultimo_acionamento;
    }

    public void setDt_ultimo_acionamento(LocalDate dt_ultimo_acionamento) {
        this.dt_ultimo_acionamento = dt_ultimo_acionamento;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }
}

