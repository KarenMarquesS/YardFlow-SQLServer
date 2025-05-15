package org.example.yardflow.dto;


import org.example.yardflow.model.Cliente;
import org.example.yardflow.model.Moto;
import org.example.yardflow.model.PlanoEnum;

public class ClienteDTO {

    private int idCliente;
    private String nome;
    private String cpf;
    private String telefone;
    private boolean ativo;
    private PlanoEnum plano;
    private Moto moto;


    public ClienteDTO() {
    }

    public ClienteDTO(int idCliente, String nome, String cpf, String telefone, boolean ativo, PlanoEnum plano, Moto moto) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.ativo = ativo;
        this.plano = plano;
        this.moto = moto;
    }

    public ClienteDTO(Cliente cliente) {
        setIdCliente(cliente.getIdCliente());
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
