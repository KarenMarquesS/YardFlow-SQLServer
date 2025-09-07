package org.example.yardflow.service;

import org.example.yardflow.dto.VagaDTO;
import org.example.yardflow.model.EnumSetor;
import org.example.yardflow.model.Patio;
import org.example.yardflow.model.Vaga;
import org.example.yardflow.repository.PatioRepositorio;
import org.example.yardflow.repository.VagaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class VagaCachingService {

    @Autowired
    private VagaRepositorio vRep;

    @Autowired
    private PatioRepositorio pRep;

    // Criar nova vaga
    public VagaDTO criarVaga(VagaDTO dto) {
        Vaga vaga = new Vaga();
        vaga.setOcupada(dto.isOcupada());
        vaga.setSetor(dto.getSetor());

        // Busca o Patio relacionado
        Optional<Patio> patio = pRep.findByIdPatio(dto.getId_patio());
        if (patio.isEmpty()) {
            throw new IllegalArgumentException(">> Patio informado não existe! <<");
        }
        vaga.setPatio(patio.get());

        Vaga vagaSalva = vRep.save(vaga);
        return new VagaDTO(vagaSalva);
    }

    @Cacheable(value= "vagaCache", key = "'ocupada' + #ocupada")
    public List<VagaDTO> vagaOcupada(boolean ocupada){
        return vRep.vagaOcupada(ocupada).stream().map(VagaDTO::new).collect(Collectors.toList());
    }

    @Cacheable(value =  "vagaCache", key="'vaga:' + #id_vaga")
    public Optional<VagaDTO> findByIdVaga(int id_vaga){
        return vRep.findByIdVaga(id_vaga).map(VagaDTO::new);
    }

    @Cacheable(value =  "vagaCache", key = "'setor:' + #setor")
    public List<VagaDTO> findVagaBySetor(EnumSetor setor){
        return vRep.findVagaBySetor(setor).stream().map(VagaDTO::new).collect(Collectors.toList());
    }


    // Deletar vaga
    public void deletarVaga(int id_vaga) {
        if (!vRep.existsById(id_vaga)) {
            throw new IllegalArgumentException(">> Vaga deletada com Sucesso <<");
        }
        vRep.deleteById(id_vaga);
    }

    @CacheEvict(value =  "vagaCache", allEntries = true)
    public void limparCaheVaga(){
        System.out.println(">> Removendo arquivos de cache da Vagas! <<");
    }
}
