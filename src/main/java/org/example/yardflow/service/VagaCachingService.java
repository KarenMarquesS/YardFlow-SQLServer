package org.example.yardflow.service;

import org.example.yardflow.dto.VagaDTO;
import org.example.yardflow.model.SetorEnum;
import org.example.yardflow.repository.VagaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class VagaCachingService {

    @Autowired
    private VagaRepositorio vRep;


    @Cacheable(value="VagaOcupada", key = "#ocupada")
    public List<VagaDTO> vagaOcupada(boolean ocupada){
        return vRep.vagaOcupada(ocupada).stream().map(VagaDTO::new).collect(Collectors.toList());
    }

    @Cacheable(value = "BuscaPorId_vaga", key="#id_vaga")
    public List<VagaDTO> buscarIdVaga(int id_vaga){
        return vRep.buscarIdVaga(id_vaga).stream().map(VagaDTO::new).collect(Collectors.toList());
    }

    @Cacheable(value = "VagasPorSetor", key = "#setor")
    public List<VagaDTO> buscarVagaSetor(SetorEnum setor){
        return vRep.buscarVagaSetor(setor).stream().map(VagaDTO::new).collect(Collectors.toList());
    }

    @CacheEvict(value = {"vagaOcupada", "BuscaPorId_vaga", "VagaPorSetor"}, allEntries = true)
    public void limparCaheVaga(){
        System.out.println(">> Removendo arquivos de cache da Vagas! <<");
    }
}
