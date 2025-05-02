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

    @Column(name = "cnh", length = 9)
    private String cnh;
    private String email;

    @Column(name = "telefone", length = 11)
    private String telefone;

    private PlanoEnum plano;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<org.example.yardflow.model.Moto> motos = new ArrayList<Moto>();

}
