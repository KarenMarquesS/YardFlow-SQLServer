package org.example.yardflow.service;

import org.example.yardflow.dto.PatioDTO;
import org.example.yardflow.model.Patio;
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
    private PatioRepositorio ptR;


    @Cacheable(value="patioCache", key = "#id_patio")
    public Optional<Patio> buscarPatioPorId(int id_patio){
        return ptR.findById(id_patio);
    }

    @Cacheable(value = "patioCache", key = "'qtd_' + #qtd_vagas")
    public List<Patio> buscarQtdVagas(int qtd_vagas){
        if (qtd_vagas > 0){
            throw new IllegalArgumentException("Quantidade de vagas deve ser maoir de ZERO");
        }
        List<Patio> patios = ptR.findByQtdVagas(qtd_vagas);
        if (patios.isEmpty()){throw new IllegalArgumentException("Nenhuma pátio encontrado com a quaindade de vaga informado");
        }
        return patios;
    }

    @Cacheable(value="patioCache", key = "#name")
    public List<Patio> buscarPatioPorNome(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("O nome do pátio não pode ser vazio");
        }
        Patio patio = ptR.findByName(name);
        if (patio == null){
            throw new IllegalArgumentException("Nome " + name + "Não encontrado");
        }
        return (List<Patio>) patio;
    }


    @CacheEvict(value="patioCache", allEntries=true)
    public Patio inserirPatio(PatioDTO dto){
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new IllegalArgumentException("O nome do pátio é obrigatório");
        }
        Patio patio = dto.toEntity();
        return ptR.save(patio);
    }


    @CacheEvict(value="patioCache", allEntries=true)
    public Patio atualizarPatio(int id_patio, PatioDTO dto){
        Patio existente = ptR.findById(id_patio)
                .orElseThrow(() -> new IllegalArgumentException("ID informado não localizado"));

        existente.setName(dto.getName());
        existente.setQtd_vagas(dto.getQtd_vagas()); // camelCase mais recomendado

        return ptR.save(existente);
    }


    @CacheEvict(value = "patioCache", allEntries = true)
    public void deletarPatio(int id_patio){
        if (!ptR.existsById(id_patio)){
            throw new IllegalArgumentException("Pátio não localizado");
        }
        ptR.deleteById(id_patio);
    }


    @CacheEvict(value = "patioCache", allEntries = true)
    public void limparCache(){
        System.out.println(" Removendo arquivos de cache de Patio! ");

    }
}
