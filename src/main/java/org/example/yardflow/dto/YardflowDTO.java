package org.example.yardflow.dto;


import org.example.yardflow.model.Moto;


import java.time.LocalDate;
import java.util.UUID;


public class YardflowDTO {

    private UUID id_yf;
    private String serial;
    private LocalDate dt_ultimo_acionamento;
    private Moto moto;


    public YardflowDTO() {
    }

    public YardflowDTO(UUID id_yf, String serial) {
        this.id_yf = id_yf;
        this.serial = serial;
    }


    public YardflowDTO(UUID id_yf, String serial, LocalDate dt_ultimo_acionamento, Moto moto) {
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

