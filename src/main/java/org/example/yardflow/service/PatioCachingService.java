package org.example.yardflow.service;



import org.example.yardflow.model.Patio;
import org.example.yardflow.model.SetorEnum;
import org.example.yardflow.model.Vaga;
import org.example.yardflow.repository.PatioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatioCachingService {

    @Autowired
    private PatioRepositorio repPt;

    @Cacheable(value = "BuscarPorSetor", key = "setor")
    public Optional<Patio> buscarPorSetor(SetorEnum setor){
        return Optional.ofNullable(repPt.buscarPorSetor(setor));
    }

    @Cacheable(value = "BuscarPorIdVaga", key = "'idVaga'")
    public Optional<Patio> buscarPorIdVagas(String idVaga){
        if(idVaga == null || idVaga.isEmpty()){
            return Optional.empty();
        }
        return Optional.ofNullable(repPt.buscarPorIdVagas(idVaga));
    }

    @Cacheable(value = "MostrarQtdVagas", key = "#qtdVagas")
    public List<Vaga> mostrarQtdVagas(int qtdVagas){
        return repPt.mostrarQtdVagas(qtdVagas);
    }

    @Cacheable(value = "VagasOcupadaPorSetor", key = "#VagaSetor")
    public List<SetorEnum> mostrarVagaOcupadaPorSetor(){
        return repPt.mostrarVagaOcupadaPorSetor();
    }

    @CacheEvict(value = {"buscarPorSetor", "buscarPorIdVagas","mostrarQtdVagas", "mostrarVagaOcupadaPorSetor"}, allEntries = true)
    public void limparCache(){
        System.out.println(">> Removendo arquivos de cache de Patio! <<");

    }

}
