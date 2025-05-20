package org.example.yardflow.dto;


import org.example.yardflow.model.Cliente;
import org.example.yardflow.model.Moto;
import org.example.yardflow.model.PlanoEnum;

public class ClienteDTO {

    private int id_cliente;
    private String nome;
    private String cpf;
    private String telefone;
    private boolean ativo;
    private PlanoEnum plano;
    private Moto moto;


    public ClienteDTO() {
    }

    public ClienteDTO(int id_cliente, String nome, String cpf, String telefone, boolean ativo, PlanoEnum plano, Moto moto) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.ativo = ativo;
        this.plano = plano;
        this.moto = moto;
    }

    public ClienteDTO(Cliente cliente) {
        setId_cliente(cliente.getId_cliente());
        setNome(cliente.getNome());
        setCpf(cliente.getCpf());
        setTelefone(cliente.getTelefone());
        setAtivo(cliente.isAtivo());
        setPlano(cliente.getPlano());
        setMoto(cliente.getMoto());
    }

    public boolean isAtivo() {return ativo;}

    public void setAtivo(boolean ativo) {this.ativo = ativo;}

    public Moto getMoto() {return moto;}

    public void setMoto(Moto moto) {this.moto = moto;}

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
