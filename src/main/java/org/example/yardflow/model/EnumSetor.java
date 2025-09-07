package org.example.yardflow.model;

public enum EnumSetor {
    PENDENCIA("Pendência"), REPAROS_SIMPLES("Reparos Simples"),
    DANOS_GRAVES("Danos Graves"), MOTOR_DEFEITUOSO("Motor Defeituoso"),
    MANUTENCAO("Manutenção"), DISPONIVEL_ALUGUEL("Disponível Aluguel"),
    SEM_PLACA("Sem Placa"), MINHA_MOTTU("Minha Mottu");


    private final String descricao;

    private EnumSetor(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}