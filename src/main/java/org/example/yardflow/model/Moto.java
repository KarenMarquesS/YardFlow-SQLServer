package org.example.yardflow.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.yardflow.model.ModeloEnum;

import java.time.LocalDate;


@Data
@Entity
@Table
public class Moto {


    @Id
    private long idMoto;

    @Enumerated(EnumType.STRING)
    private ModeloEnum modelo;
    private LocalDate ano_fabricacao;

    @Column(length = 17)
    private String chassi;

    @Column(length = 17)
    private String n_motor;

    @Column(length = 7)
    private String placa;

    @Column(length = 1000)
    private String historico;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

}
