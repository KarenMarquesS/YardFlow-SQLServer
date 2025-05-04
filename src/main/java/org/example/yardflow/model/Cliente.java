package org.example.yardflow.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.yardflow.model.PlanoEnum;


import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "clienteMottu")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nome;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "telefone", length = 11)
    private String telefone;

    @Enumerated(EnumType.STRING)
    private PlanoEnum plano;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Moto> moto = new ArrayList<>();

}
