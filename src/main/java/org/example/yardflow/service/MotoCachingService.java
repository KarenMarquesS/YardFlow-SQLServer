package org.example.yardflow.service;


import org.example.yardflow.dto.ModelMapper;
import org.example.yardflow.dto.MotoDTO;
import org.example.yardflow.model.Moto;
import org.example.yardflow.repository.MotoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MotoCachingService {

    @Autowired
    private MotoRepositorio repMt;

    @Autowired
    private ModelMapper mM;

    // caching da busca por id da moto
    @Cacheable(value = "buscarIdMoto", key ="#id_moto")
    public Optional<Moto> findById(int id_moto) {
        return repMt.findById(id_moto);
    }

    // caching das páginas de motos
    @Cacheable(value = "HistoricoPaginado", key = "#req")
    public Page<MotoDTO> getAllMotosPaginado(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Moto> motoPage = repMt.findAll(pageable);

        return motoPage.map(moto -> mM.map(moto, MotoDTO.class));
    }

    // caching de limpeza
    @CacheEvict(value = {"buscarIdMoto", "PaginaMoto", "HistoricoPaginado"}, allEntries = true)
    public void limparCache(){
        System.out.println(">> Removendo arquivos de cache de Motos! <<");
    }


}
