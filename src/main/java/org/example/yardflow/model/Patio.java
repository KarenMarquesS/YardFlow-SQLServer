package org.example.yardflow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patio")
public class Patio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_patio;

    @Column(nullable = false, length = 200)
    private String endereco;

    @Column(nullable = false)
    private int qtd_vagas;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private EnumSetor setor;

    @OneToMany(mappedBy = "patio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaga> vagas;

}

