package org.example.yardflow.service;



import org.example.yardflow.model.Patio;
import org.example.yardflow.model.EnumSetor;
import org.example.yardflow.repository.PatioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PatioCachingService {

    @Autowired
    private PatioRepositorio ptRep;

    public Optional<Patio> buscarPatioPorId(int id_patio) {
        return ptRep.findByIdPatio(id_patio);
    }

    @CacheEvict(value = "patioCache", allEntries = true)
    public Patio atualizar(int id_patio, Patio patioAtualizado) {
        return ptRep.findById(id_patio).map(patio -> {
            patio.setEndereco(patioAtualizado.getEndereco());
            patio.setQtd_vagas(patioAtualizado.getQtd_vagas());
            patio.setSetor(patioAtualizado.getSetor());
            return ptRep.save(patio);
        }).orElseThrow(() -> new IllegalArgumentException("Pátio não encontrado: " + id_patio));
    }


    @Cacheable(value = "patioCache", key = "'setor:' + #setor")
    public List<Patio> buscarPorSetor(EnumSetor setor){
        return ptRep.findBySetor(setor);
    }

    @Cacheable(value = "patioCache", key = "'id' + #id_vaga")
    public Optional<Patio> buscarPorIdVagas(int id_vaga){
        if(id_vaga <=0){
            return Optional.empty();
        }
        return Optional.ofNullable(ptRep.findByIdVaga(id_vaga));
    }

    @Cacheable(value = "patioCache", key = "'qtd_vaga' + #qtd_vagas")
    public List<Patio> mostrarQtdVagas(int qtd_vagas){
        return ptRep.findByQtdVagas(qtd_vagas);
    }


    @Cacheable(value = "patioCache", key = "#ocupadaPorSetor")
    public List<Object[]> mostrarVagaOcupadaPorSetor(){
        return ptRep.contarVagaOcupadaPorSetor();
    }

    @CacheEvict(value = "patioCache", allEntries = true)
    public void deletarPatio(int id_patio) {
        if (!ptRep.existsById(id_patio)) {
            throw new IllegalArgumentException("Pátio não encontrado: " + id_patio);
        }
        ptRep.deleteById(id_patio);
    }

    @CacheEvict(value = "patioCache", allEntries = true)
    public void limparCache(){
        System.out.println(">> Removendo arquivos de cache de Patio! <<");

    }
}
