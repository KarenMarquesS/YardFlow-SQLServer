package org.example.yardflow.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="tb_yf_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @Pattern(regexp = "^(.+)@(.+)$", message = "Dgite um e-mail válido")
    private String email;

    @Enumerated(EnumType.STRING)
    private EnumFuncao funcao;

}
