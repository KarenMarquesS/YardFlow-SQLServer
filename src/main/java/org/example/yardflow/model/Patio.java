package org.example.yardflow.model;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_yf_patio")
public class Patio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpatio;

    private String name;

    @Column(nullable = false)
    private int qtdvagas;


    public Patio() {
    }

    public Patio(int idpatio, String name, int qtdvagas) {
        this.idpatio = idpatio;
        this.name = name;
        this.qtdvagas = qtdvagas;
    }

    public int getIdpatio() {
        return idpatio;
    }

    public void setIdpatio(int idpatio) {
        this.idpatio = idpatio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtdvagas() {
        return qtdvagas;
    }

    public void setQtdvagas(int qtdvagas) {
        this.qtdvagas = qtdvagas;
    }
}

