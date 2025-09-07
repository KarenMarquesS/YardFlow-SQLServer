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
@Table(name = "moto")
public class Moto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_moto;

    @Enumerated(EnumType.STRING)
    private EnumModelo modelo;

    private String chassi;

    private String placa;

    private String historico;

    private int yFlowIoT;

    @Column(nullable = false)
    private boolean ativo = true;

    @OneToMany(mappedBy = "moto", cascade = CascadeType.ALL)
    private List<RegistroCheckInOut> registrosCheckInOut;

}
