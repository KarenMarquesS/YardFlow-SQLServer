package org.example.yardflow.dto;


import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.example.yardflow.model.Cliente;
import org.example.yardflow.model.PlanoEnum;
import org.modelmapper.ModelMapper;

public class ClienteDTO {

    private int id_cliente;
    @NotBlank(message = "Informe o Nome Completo")
    @Size(min = 200, max = 350)
    private String nome;
    @NotBlank(message = "Informe o CPF - apenas números")
    @Size(max = 11)
    private String cpf;
    private String telefone;
    @AssertTrue(message="O ID do cleinte deve estar vazio no momento do cadastro")
    private boolean ativo;
    private PlanoEnum plano;
    private MotoDTO moto;



    public ClienteDTO(int id_cliente, String nome, String cpf, String telefone, boolean ativo, PlanoEnum plano, MotoDTO moto) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.ativo = ativo;
        this.plano = plano;
        this.moto = moto;
    }

    public ClienteDTO(Cliente cliente, ModelMapper modelMapper) {
        setId_cliente(cliente.getId_cliente());
        setNome(cliente.getNome());
        setCpf(cliente.getCpf());
        setTelefone(cliente.getTelefone());
        setAtivo(cliente.isAtivo());
        setPlano(cliente.getPlano());
        setMoto(modelMapper.map(cliente.getMoto(), MotoDTO.class));
    }

    public ClienteDTO(Cliente cliente) {
        this.id_cliente = cliente.getId_cliente();
        this.nome = cliente.getNome();
        this.ativo = cliente.isAtivo();
    }


    public boolean isAtivo() {return ativo;}

    public void setAtivo(boolean ativo) {this.ativo = ativo;}

    public MotoDTO getMoto() {
        return moto;
    }

    public void setMoto(MotoDTO moto) {
        this.moto = moto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public PlanoEnum getPlano() {
        return plano;
    }

    public void setPlano(PlanoEnum plano) {
        this.plano = plano;
    }

}
