package org.example.yardflow.service;


import org.example.yardflow.dto.MotoDTO;
import org.example.yardflow.model.Moto;
import org.example.yardflow.repository.MotoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MotoCachingService {

    @Autowired
    private MotoRepositorio repMt;

    private MotoDTO converterParaDTO(Moto moto) {
        return new MotoDTO(
                moto.getIdMoto(),
                moto.getChassi(),
                moto.getPlaca(),
                moto.getHistorico(),
                moto.isAtivo(),
                moto.getCliente()
        );
    }

    // caching da busca por id da moto
    @Cacheable(value = "buscarIdMoto", key ="#idMoto")
    public Optional<Moto> findById(int idMoto) {
        return repMt.findById(idMoto);
    }

    // caching das páginas de motos
    @Cacheable(value = "HistoricoPaginado", key = "#req")
    public Page<MotoDTO> paginar(PageRequest req) {
        return repMt.findAll(req).map(this::converterParaDTO);
    }

    // caching de limpeza
    @CacheEvict(value = {"buscarIdMoto", "PaginaMoto", "HistoricoPaginado"}, allEntries = true)
    public void limparCache(){
        System.out.println(">> Removendo arquivos de cache de Motos! <<");
    }


}
