package org.example.yardflow.service;

import org.example.yardflow.model.Patio;
import org.example.yardflow.repository.PatioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PatioCachingService {

    @Autowired
    private PatioRepositorio ptRep;

    @Cacheable(value = "patioCache", key = "#id_patio")
    public Patio buscarPatioPorId(int id_patio) {
        return ptRep.findById(id_patio);
    }

    @Cacheable(value = "patioCache", key = "#nickname")
    public Patio buscarPatioPorNickname(String nickname) {
        return ptRep.findByNickname(nickname);
    }

    @Cacheable(value = "patioCache", key = "#qtd_vagas")
    public Patio buscarQtd_vagas(int qtd_vagas){
        return ptRep.findByqtd_vagas(qtd_vagas);
    }

    @CacheEvict(value = "patioCache", allEntries = true)
    public void limparCache(){
        System.out.println(">> Removendo arquivos de cache de Patio! <<");

    }
}
