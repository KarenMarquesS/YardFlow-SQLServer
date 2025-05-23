package org.example.yardflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;



@Data
@Entity
@Table
public class Moto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_moto;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ModeloEnum modelo;

    @Column(length = 17)
    private String chassi;

    @Column(length = 7, unique = true)
    private String placa;

    @Column(length = 400)
    private String historico;

    @Column(nullable = false)
    private boolean ativo = true;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "moto", cascade = CascadeType.ALL)
    private List<Registro_check_in_out> registrosCheckInOut;

}
