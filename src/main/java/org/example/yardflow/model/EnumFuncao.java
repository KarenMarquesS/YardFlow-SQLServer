package org.example.yardflow.model;

public enum EnumFuncao {

    MECANICO("Mecânico"), RECEPCAO("Recepção"), EXPEDICAO("Expedição"),
    VENDEDOR("Vendedor"), GERENTE_PATIO("Gerente do Pátio");


    private final String descricao;

    private EnumFuncao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

// Mecanico e Vendedor -> CONSULTAR E CHAMAR
// Recepção e Expedição -> INSERIR, CONSULTAR E CHAMAR
// Gerente -> INSERIR, CONSULTAR, CHAMAR E DELETAR