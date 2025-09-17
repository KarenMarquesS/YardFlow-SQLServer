package org.example.yardflow.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity
@Table(name = "tb_yf_moto")
public class Moto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_moto;

    @Enumerated(EnumType.STRING)
    private EnumModelo modelo;

    private String chassi;

    private String placa;

    private String historico;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private YfIoT yfIoT;

    @OneToMany(mappedBy = "moto", cascade = CascadeType.ALL)
    private List<Registro_check_in_out> registrosCheckInOut;

}
