package org.example.yardflow.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;



@Data
@Entity
@Table
public class Moto {


    @Id
    private int id_moto;

    @Enumerated(EnumType.STRING)
    private ModeloEnum modelo;

    @Column(length = 17)
    private String chassi;

    @Column(length = 7)
    private String placa;

    @Column(length = 1000)
    private String historico;

    @Column(nullable = false)
    private boolean ativo = true;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "id_moto", cascade = CascadeType.ALL)
    private List<Registro_check_in_out> registrosCheckInOut;

}
