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
    private LocalDate dtultimoacionamento;

    @OneToOne
    @JoinColumn(name = "idmoto", referencedColumnName = "idmoto", nullable = false, unique = true)
    private Moto moto;


    public Yardflow() {
    }

    public Yardflow(int idyf, String serial, LocalDate dtultimoacionamento, Moto moto) {
        this.idyf = idyf;
        this.serial = serial;
        this.dtultimoacionamento = dtultimoacionamento;
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

    public LocalDate getDtultimoacionamento() {
        return dtultimoacionamento;
    }

    public void setDtultimoacionamento(LocalDate dtultimoacionamento) {
        this.dtultimoacionamento = dtultimoacionamento;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }
}

