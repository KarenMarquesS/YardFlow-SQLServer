package org.example.yardflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import org.example.yardflow.model.ModeloEnum;
import org.example.yardflow.model.Moto;
import org.modelmapper.ModelMapper;

public class MotoDTO {

    private int id_moto;

    private ModeloEnum modelo;

    @Size(min = 17, max = 17, message = "Chassi deve ter 17 caracteres")
    private String chassi;

    @Size(min = 6, max = 7, message = "Placa deverá ter 7 caracteres")
    @Pattern(regexp = "^[A-Z]{3}[0-9][0-9A-Z][0-9]{2}$", message = "Placa inválida. Use o formato ABC1D23.")
    private String placa;

    @NotBlank(message = "Registre o motivo da moto entrar no pátio, 4000 caracteres")
    @Size(min = 300, max = 4000, message = "Registre o motivo")
    private String historico;

    private boolean ativo;
    private ClienteDTO cliente;



    public MotoDTO() {
    }

    public MotoDTO(Moto moto, ModelMapper modelMapper) {
        modelMapper.map(moto, this);
        this.id_moto = moto.getId_moto();
        this.modelo = moto.getModelo();
        this.chassi = moto.getChassi();
        this.placa = moto.getPlaca();
        this.historico = moto.getHistorico();
        this.ativo = moto.isAtivo();
        this.cliente = modelMapper.map(moto.getCliente(), ClienteDTO.class);
    }

    public int getId_moto() {
        return id_moto;
    }

    public void setId_moto(int id_moto) {
        this.id_moto = id_moto;
    }

    public ModeloEnum getModelo() {
        return modelo;
    }

    public void setModelo(ModeloEnum modelo) {
        this.modelo = modelo;
    }

    public @Size(min = 17, max = 17, message = "Chassi deve ter 17 caracteres") String getChassi() {
        return chassi;
    }

    public void setChassi(@Size(min = 17, max = 17, message = "Chassi deve ter 17 caracteres") String chassi) {
        this.chassi = chassi;
    }

    public @Size(min = 7, max = 7, message = "Placa deverá ter 7 caracteres") String getPlaca() {
        return placa;
    }

    public void setPlaca(@Size(min = 7, max = 7, message = "Placa deverá ter 7 caracteres") String placa) {
        this.placa = placa;
    }

    public @NotBlank(message = "Registre o motivo da moto entrar no pátio, 4000 caracteres") @Size(min = 300, max = 4000, message = "Registre o motivo") String getHistorico() {
        return historico;
    }

    public void setHistorico(@NotBlank(message = "Registre o motivo da moto entrar no pátio, 4000 caracteres") @Size(min = 300, max = 4000, message = "Registre o motivo") String historico) {
        this.historico = historico;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
}