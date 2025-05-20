package org.example.yardflow.dto;


import jakarta.validation.constraints.NotBlank;
import org.example.yardflow.model.Patio;
import org.example.yardflow.model.SetorEnum;
import org.example.yardflow.model.Vaga;

import java.util.List;
import java.util.stream.Collectors;

public class VagaDTO {

    private int id_vaga;
    @NotBlank(message = "Informe o Setor")
    private SetorEnum setor;
    private boolean ocupada;
    private Patio patio;
    private List<Registro_check_in_outDTO> registro;


    public VagaDTO() {
    }

    public VagaDTO(int id_vaga, SetorEnum setor, boolean ocupada, Patio patio, List<Registro_check_in_outDTO> registro) {
        this.id_vaga = id_vaga;
        this.setor = setor;
        this.ocupada = ocupada;
        this.patio = patio;
        this.registro = registro;
    }



    public VagaDTO(Vaga vaga){
       setId_vaga(vaga.getId_vaga());
       setOcupada(vaga.isOcupada());
       setSetor(vaga.getSetor());
       setPatio(vaga.getPatio());
       setRegistro(vaga.getRegistrosCheckInOut()
               .stream()
               .map(Registro_check_in_outDTO::new)
               .collect(Collectors.toList()));
    }

    public int getId_vaga() {
        return id_vaga;
    }

    public void setId_vaga(int id_vaga) {
        this.id_vaga = id_vaga;
    }

    public SetorEnum getSetor() {
        return setor;
    }

    public void setSetor(SetorEnum setor) {
        this.setor = setor;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Patio getPatio() {
        return patio;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    public List<Registro_check_in_outDTO> getRegistro() {
        return registro;
    }

    public void setRegistro(List<Registro_check_in_outDTO> registro) {
        this.registro = registro;
    }
}
