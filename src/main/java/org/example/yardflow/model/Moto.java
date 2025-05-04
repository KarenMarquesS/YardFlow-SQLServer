package org.example.yardflow.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.yardflow.model.ModeloEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table
public class Moto {


    @Id
    private int idMoto;

    @Enumerated(EnumType.STRING)
    private ModeloEnum modelo;

    private String anoFabricacao;

    @Column(length = 17)
    private String chassi;

    @Column(length = 17)
    private String nMotor;

    @Column(length = 7)
    private String placa;

    @Column(length = 1000)
    private String historico;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "moto", cascade = CascadeType.ALL)
    private List<RegistroCheckIn_Out> registrosCheckInOut = new ArrayList<>();

}
