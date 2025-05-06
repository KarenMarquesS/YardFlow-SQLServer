package org.example.yardflow.DTO;


import org.example.yardflow.model.Cliente;
import org.example.yardflow.model.Moto;
import org.example.yardflow.model.PlanoEnum;

import java.util.ArrayList;
import java.util.List;

public class ClienteDTO {

    private int idCliente;
    private String nome;
    private String cpf;
    private String telefone;
    private PlanoEnum plano;
    private List<Moto> moto = new ArrayList<>();


    public ClienteDTO() {
    }

    public ClienteDTO(int idCliente, String nome, String cpf, String telefone, PlanoEnum plano, List<Moto> moto) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.plano = plano;
        this.moto = moto;
    }

    public ClienteDTO(Cliente cliente) {
        setIdCliente(cliente.getIdCliente());
        setMoto(cliente.getMoto());
    }

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

    public String getCpf() {
        return cpf;
    }

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

    public List<Moto> getMoto() {
        return moto;
    }

    public void setMoto(List<Moto> moto) {
        this.moto = moto;
    }
}
