package org.example.yardflow.dto;

import org.example.yardflow.model.EnumFuncao;

public class UsuarioDTO {

    private long id;
    private String nome;
    private String email;
    private EnumFuncao funcao;

    public UsuarioDTO() {
    }

    public UsuarioDTO(long id, String nome, String email, EnumFuncao funcao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.funcao = funcao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnumFuncao getFuncao() {
        return funcao;
    }

    public void setFuncao(EnumFuncao funcao) {
        this.funcao = funcao;
    }
}
