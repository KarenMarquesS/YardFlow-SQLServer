package org.example.yardflow.service;

import org.example.yardflow.model.Moto;
import org.example.yardflow.repository.MotoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;


@Service
public class MotoCachingService {

    @Autowired
    private MotoRepositorio repMt;

    // caching da busca por id da moto
    @Cacheable(value = "motoCache", key ="'id:' + #id_moto")
    public Moto findById(int id_moto) {
        return repMt.findById(id_moto);
    }

    @Cacheable(value = "motoCache", key="'placa:' + #placa")
    public Moto findByPlaca(String placa) {
        return repMt.findByPlaca(placa);
    }

    @Cacheable(value = "motoCache", key="'chassi:' + #chassi")
    public Moto findByChassi(String chassi) {
        return repMt.findByChassi(chassi);
    }

    @Cacheable(value="motoCache", key = "'historico:' + #id_moto")
    public String mostrarHistoricoMoto(int id_moto){
        return repMt.mostrarHistoricoMoto(id_moto);
    }


    // caching de limpeza
    @CacheEvict(value = "motoCache", allEntries = true)
    public void limparCache(){

        System.out.println(">> Removendo arquivos de cache de Motos! <<");
    }


}
