package org.example.yardflow.dto;


import jakarta.validation.constraints.Positive;
import org.example.yardflow.model.Patio;


public class PatioDTO {

    private int id_patio;

    private String name;

    @Positive
    private int qtd_vagas;


    // Conversão de entidade em DTO
    public Patio toEntity() {
        Patio p = new Patio();
        this.id_patio = p.getId_patio();
        this.qtd_vagas = p.getQtd_vagas();
        this.name = p.getName();

        return p;
    }

    public PatioDTO() {
    }

    public PatioDTO(int id_patio, String name, int qtd_vagas) {
        this.id_patio = id_patio;
        this.name = name;
        this.qtd_vagas = qtd_vagas;
    }

    public PatioDTO(Patio patio) {
        this.id_patio = patio.getId_patio();
        this.name = patio.getName();
        this.qtd_vagas = patio.getQtd_vagas();
    }

    public int getId_patio() {
        return id_patio;
    }

    public void setId_patio(int id_patio) {
        this.id_patio = id_patio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Positive
    public int getQtd_vagas() {
        return qtd_vagas;
    }

    public void setQtd_vagas(@Positive int qtd_vagas) {
        this.qtd_vagas = qtd_vagas;
    }
}
