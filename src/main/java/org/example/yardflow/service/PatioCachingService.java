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
import java.util.stream.Collectors;


@Service
public class PatioCachingService {

    @Autowired
    private PatioRepositorio ptRep;

    @Cacheable(value = "BuscarPorSetor", key = "#setor")
    public Optional<Patio> buscarPorSetor(SetorEnum setor){
        return Optional.ofNullable(ptRep.buscarPorSetor(setor));
    }

    @Cacheable(value = "BuscarPorIdVaga", key = "#'id_vaga'")
    public Optional<Patio> buscarPorIdVagas(int id_vaga){
        if(id_vaga <=0){
            return Optional.empty();
        }
        return Optional.ofNullable(ptRep.buscarPorIdVagas(id_vaga));
    }

    @Cacheable(value = "MostrarQtdVagas", key = "#qtd_vagas")
    public List<Patio> mostrarQtdVagas(int qtd_vagas){
        return ptRep.mostrarQtdVagas(qtd_vagas);
    }

    @Cacheable(value = "VagasOcupadaPorSetor", key = "#vaga_setor")
    public List<SetorEnum> mostrarVagaOcupadaPorSetor(){
        List<Object[]> result = ptRep.mostrarVagaOcupadaPorSetor();
        return result.stream().map(obj -> (SetorEnum) obj[0]).collect(Collectors.toList());
    }

    @CacheEvict(value = {"BuscarPorSetor", "BuscarPorIdVaga","MostrarQtdVagas", "VagasOcupadaPorSetor"}, allEntries = true)
    public void limparCache(){
        System.out.println(">> Removendo arquivos de cache de Patio! <<");

    }
}
