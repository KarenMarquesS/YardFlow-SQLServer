package org.example.yardflow.model;

import jakarta.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "tb_yf_IoT")
public class Yardflow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idyf;

    @Column(nullable = false, unique = true)
    private String serial;

    @Column(name = "dtultimoacionamento")
    private LocalDateTime dtUltimoAcionamento;

    @OneToOne(mappedBy = "yardflow")
    private Moto moto;


    public Yardflow() {
    }

    public Yardflow(int idyf, String serial, LocalDateTime dtultimoacionamento, Moto moto) {
        this.idyf = idyf;
        this.serial = serial;
        this.dtUltimoAcionamento = dtultimoacionamento;
        this.moto = moto;
    }

    public int getIdyf() {
        return idyf;
    }

    public void setIdyf(int idyf) {
        this.idyf = idyf;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public LocalDateTime getDtultimoacionamento() {
        return dtUltimoAcionamento;
    }

    public void setDtultimoacionamento(LocalDateTime dtultimoacionamento) {
        this.dtUltimoAcionamento = dtultimoacionamento;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }
}

