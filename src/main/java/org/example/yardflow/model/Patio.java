package org.example.yardflow.model;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_yf_patio")
public class Patio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_patio;

    private String name;

    @Column(nullable = false)
    private int qtd_vagas;


    public Patio() {
    }

    public Patio(int id_patio, String name, int qtd_vagas) {
        this.id_patio = id_patio;
        this.name = name;
        this.qtd_vagas = qtd_vagas;
    }

    public int getId_patio() {
        return id_patio;
    }

    public void setId_patio(int id_patio) {
        this.id_patio = id_patio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtd_vagas() {
        return qtd_vagas;
    }

    public void setQtd_vagas(int qtd_vagas) {
        this.qtd_vagas = qtd_vagas;
    }
}

