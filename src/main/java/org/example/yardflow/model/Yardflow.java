package org.example.yardflow.model;

import jakarta.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;



@Entity
@Table(name = "tb_yf_IoT")
public class Yardflow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idyf;

    @Column(nullable = false, unique = true)
    private String serial;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dt_ultimo_acionamento;

    @OneToOne
    @JoinColumn(name = "idmoto", referencedColumnName = "idmoto", nullable = false, unique = true)
    private Moto moto;


    public Yardflow() {
    }

    public Yardflow(int idyf, String serial, LocalDate dt_ultimo_acionamento, Moto moto) {
        this.idyf = idyf;
        this.serial = serial;
        this.dt_ultimo_acionamento = dt_ultimo_acionamento;
        this.moto = moto;
    }

    public int getId_yf() {
        return idyf;
    }

    public void setId_yf(int idyf) {
        this.idyf = idyf;
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

