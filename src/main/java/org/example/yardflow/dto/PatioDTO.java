//package org.example.yardflow.dto;
//
//
//import jakarta.validation.constraints.Positive;
//import org.example.yardflow.model.Patio;
//
//
//public class PatioDTO {
//
//    private int idpatio;
//
//    private String name;
//
//    @Positive
//    private int qtdvagas;
//
//
//    // Conversão de entidade em DTO
//    public Patio toEntity() {
//        Patio p = new Patio();
//        this.idpatio = p.getIdpatio();
//        this.qtdvagas = p.getQtdvagas();
//        this.name = p.getName();
//
//        return p;
//    }
//
//    public PatioDTO() {
//    }
//
//    public PatioDTO(int idpatio, String name, int qtdvagas) {
//        this.idpatio = idpatio;
//        this.name = name;
//        this.qtdvagas = qtdvagas;
//    }
//
//    public PatioDTO(Patio patio) {
//        this.idpatio = patio.getIdpatio();
//        this.name = patio.getName();
//        this.qtdvagas = patio.getQtdvagas();
//    }
//
//    public int getIdpatio() {
//        return idpatio;
//    }
//
//    public void setId_patio(int idpatio) {
//        this.idpatio = idpatio;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Positive
//    public int getQtdvagas() {
//        return qtdvagas;
//    }
//
//    public void setQtd_vagas(@Positive int qtdvagas) {
//        this.qtdvagas = qtdvagas;
//    }
//}
