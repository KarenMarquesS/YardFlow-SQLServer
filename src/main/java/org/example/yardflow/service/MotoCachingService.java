package org.example.yardflow.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.yardflow.dto.MotoDTO;
import org.example.yardflow.model.Moto;
import org.example.yardflow.repository.MotoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class MotoCachingService {

    @Autowired
    private MotoRepositorio mtRp;

    @Autowired
    private ModelMapper mm;

    @Cacheable(value = "motoCache", key = "#id_moto")
    public Optional<Moto> findById(int id_moto) {
        return mtRp.findById(id_moto);
    }

    @Cacheable(value = "motoCache", key = "'placa:' + #placa")
    public MotoDTO findByPlaca(String placa) {
        Moto moto = mtRp.findByPlaca(placa);
        return mm.map(moto, MotoDTO.class);
    }

    @Cacheable(value = "motoCache", key = "'chassi:' + #chassi")
    public MotoDTO findByChassi(String chassi) {
        Moto moto = mtRp.findByChassi(chassi);
        return mm.map(moto, MotoDTO.class);
    }

    @Cacheable(value = "motoCache", key = "'historico' + #id_moto")
    public MotoDTO buscarHistorico(int id_moto) {
        String moto = mtRp.historicoMoto(id_moto);
        return mm.map(moto, MotoDTO.class);
    }

    @Cacheable(value = "motoCache", key = "'paginado' + #id_moto")
    public Page<MotoDTO> findAllPaginado(Pageable pageable) {
        Page<Moto> motosPage = mtRp.findAll(pageable);
        return motosPage.map(moto -> mm.map(moto, MotoDTO.class));
    }

    @CacheEvict(value = "motoCache", allEntries = true)
    public MotoDTO criarNovaMoto(MotoDTO motoDTO) {

        motoDTO.setId_moto(0);
        Moto moto = mm.map(motoDTO, Moto.class);
        Moto savedMoto = mtRp.save(moto);
        return mm.map(savedMoto, MotoDTO.class);
    }


    @CachePut(value = "motoCache", key = "#id_moto")
    @Caching(evict = {
            @CacheEvict(value = "motoCache", key = "'placa:' + #result.placa", condition = "#result != null"),
            @CacheEvict(value = "motoCache", key = "'chassi:' + #result.chassi", condition = "#result != null")
    })
    public MotoDTO atualizarRegistroMoto(int id_moto, MotoDTO motoDTO) {

        mtRp.findById(id_moto).orElseThrow(() -> new EntityNotFoundException("Moto não encontrada: " + id_moto));

        Moto motoToUpdate = mm.map(motoDTO, Moto.class);
        motoToUpdate.setId_moto(id_moto);
        Moto updatedMoto = mtRp.save(motoToUpdate);
        return mm.map(updatedMoto, MotoDTO.class);
    }



    @CacheEvict(value = "motoCache", allEntries = true) // Invalida todo o cache, mais simples e seguro
    public void deletarRegistroMoto(int id_moto) {
        Moto moto = mtRp.findById(id_moto)
                .orElseThrow(() -> new EntityNotFoundException("Moto não encontrada: " + id_moto));
        mtRp.delete(moto);
    }


    @CacheEvict(value = "motoCache", allEntries = true)
    public void limparCache() {
        System.out.println(">> Removendo todos os caches de 'motoCache' <<");
    }


}
