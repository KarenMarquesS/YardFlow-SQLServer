package org.example.yardflow.dto;

import org.example.yardflow.model.EnumSetor;
import org.example.yardflow.model.Registro_check_in_out;

import java.time.LocalDate;



public class Registro_check_in_outDTO {

    private int id_registro;
    private LocalDate entrada_patio;
    private LocalDate saida_patio;
    private int periodo;
    private EnumSetor setor;
    private MotoDTO motoDTO;

    public Registro_check_in_outDTO(Registro_check_in_out registro) {
        this.id_registro = registro.getId_registro();
        this.entrada_patio = registro.getEntrada_patio();
        this.saida_patio = registro.getSaida_patio();
        this.periodo = registro.getPeriodo();
        this.motoDTO = new MotoDTO();

        // sobre a entidade moto
        var m = registro.getMoto();
        this.motoDTO = new MotoDTO(
                registro.getMoto().getId_moto(),
                registro.getMoto().getModelo(),
                registro.getMoto().getChassi(),
                registro.getMoto().getPlaca(),
                registro.getMoto().getHistorico(),
                registro.getMoto().getYardflow()
        );
    }

    public Registro_check_in_outDTO() {
    }

    public Registro_check_in_outDTO(int id_registro, LocalDate entrada_patio, LocalDate saida_patio, int periodo, EnumSetor setor, MotoDTO motoDTO) {
        this.id_registro = id_registro;
        this.entrada_patio = entrada_patio;
        this.saida_patio = saida_patio;
        this.periodo = periodo;
        this.setor = setor;
        this.motoDTO = motoDTO;
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public LocalDate getEntrada_patio() {
        return entrada_patio;
    }

    public void setEntrada_patio(LocalDate entrada_patio) {
        this.entrada_patio = entrada_patio;
    }

    public LocalDate getSaida_patio() {
        return saida_patio;
    }

    public void setSaida_patio(LocalDate saida_patio) {
        this.saida_patio = saida_patio;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public EnumSetor getSetor() {
        return setor;
    }

    public void setSetor(EnumSetor setor) {
        this.setor = setor;
    }

    public MotoDTO getMotoDTO() {
        return motoDTO;
    }

    public void setMotoDTO(MotoDTO motoDTO) {
        this.motoDTO = motoDTO;
    }
}
