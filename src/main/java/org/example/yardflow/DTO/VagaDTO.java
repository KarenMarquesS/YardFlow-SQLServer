package org.example.yardflow.DTO;


import org.example.yardflow.model.Patio;
import org.example.yardflow.model.SetorEnum;
import org.example.yardflow.model.Vaga;

import java.util.List;
import java.util.stream.Collectors;

public class VagaDTO {

    private String idVaga;
    private SetorEnum setor;
    private boolean ocupada;
    private Patio patio;
    private List<RegistroCheckInOutDTO> registro;


    public VagaDTO() {
    }

    public VagaDTO(String idVaga, SetorEnum setor, boolean ocupada, Patio patio, List<RegistroCheckInOutDTO> registro) {
        this.idVaga = idVaga;
        this.setor = setor;
        this.ocupada = ocupada;
        this.patio = patio;
        this.registro = registro;
    }



    public VagaDTO(Vaga vaga){
       setIdVaga(vaga.getIdVaga());
       setOcupada(vaga.isOcupada());
       setSetor(vaga.getSetor());
       setPatio(vaga.getPatio());
       setRegistro(vaga.getRegistrosCheckInOut()
               .stream()
               .map(RegistroCheckInOutDTO::new)
               .collect(Collectors.toList()));
    }

    public String getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(String idVaga) {
        this.idVaga = idVaga;
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

    public List<RegistroCheckInOutDTO> getRegistro() {
        return registro;
    }

    public void setRegistro(List<RegistroCheckInOutDTO> registro) {
        this.registro = registro;
    }
}
