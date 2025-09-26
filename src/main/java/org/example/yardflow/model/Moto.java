package org.example.yardflow.model;

import jakarta.persistence.*;


import java.util.List;


@Entity
@Table(name = "tb_yf_moto")
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmoto;

    @Enumerated(EnumType.STRING)
    private EnumModelo modelo;

    private String chassi;

    private String placa;

    private String historico;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "yardflow_idyf", referencedColumnName = "idyf")
    private Yardflow yardflow;

    @OneToMany(mappedBy = "moto", cascade = CascadeType.ALL)
    private List<Registro_check_in_out> registrosCheckInOut;


    public Moto() {
    }

    public Moto(int idmoto, EnumModelo modelo, String chassi, String placa, String historico, Yardflow yardflow, List<Registro_check_in_out> registrosCheckInOut) {
        this.idmoto = idmoto;
        this.modelo = modelo;
        this.chassi = chassi;
        this.placa = placa;
        this.historico = historico;
        this.yardflow = yardflow;
        this.registrosCheckInOut = registrosCheckInOut;
    }

    public int getIdmoto() {
        return idmoto;
    }

    public void setIdmoto(int idmoto) {
        this.idmoto = idmoto;
    }

    public EnumModelo getModelo() {
        return modelo;
    }

    public void setModelo(EnumModelo modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Yardflow getYardflow() {
        return yardflow;
    }

    public void setYardflow(Yardflow yardflow) {
        this.yardflow = yardflow;
    }

    public List<Registro_check_in_out> getRegistrosCheckInOut() {
        return registrosCheckInOut;
    }

    public void setRegistrosCheckInOut(List<Registro_check_in_out> registrosCheckInOut) {
        this.registrosCheckInOut = registrosCheckInOut;
    }
}
