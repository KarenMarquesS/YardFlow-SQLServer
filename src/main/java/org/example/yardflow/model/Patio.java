package org.example.yardflow.model;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name = "tb_yf_patio")
public class Patio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_patio;

    private String name;

    @Column(nullable = false)
    private int qtd_vagas;

}

