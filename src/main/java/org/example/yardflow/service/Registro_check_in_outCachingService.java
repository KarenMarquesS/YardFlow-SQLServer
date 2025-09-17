package org.example.yardflow.service;

import org.example.yardflow.model.Registro_check_in_out;

import org.example.yardflow.repository.Registro_check_in_outRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class Registro_check_in_outCachingService {

    @Autowired
    private Registro_check_in_outRepositorio repRg;

    @Cacheable(value = "registroCache", key = "#entrada")
    public Optional<Registro_check_in_out> buscarDataEntradaMoto(LocalDate data_entrada) {
        return repRg.buscarDataEntradaMoto(data_entrada);
    }

    @Cacheable(value = "registroCache", key = "#saida")
    public Optional<Registro_check_in_out> buscarDataSaidaMoto(LocalDate data_saida) {
        return repRg.buscarDataSaidaMoto(data_saida);
    }


    @CacheEvict(value = "registroCache", allEntries = true)
    public void limparCache(){
        System.out.println(">> Removendo arquivos de cache dos Registros <<");

    }
}



