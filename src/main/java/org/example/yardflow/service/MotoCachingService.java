package org.example.yardflow.service;



import org.example.yardflow.dto.MotoDTO;
import org.example.yardflow.model.Moto;
import org.example.yardflow.repository.MotoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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


    // caching das páginas dos historicos das motos
    @Cacheable(value = "HistoricoPaginado", key = "#req")
    public Page<MotoDTO> getAllMotosPaginado(int id_moto, int page, int size){
        Pageable pageable = PageRequest.of(page, size);

        Optional<Moto> mtOp = repMt.findById(id_moto);
        if (mtOp.isPresent()){
            Moto moto = mtOp.get();
            MotoDTO motoDTO = mM.map(moto, MotoDTO.class);

            return new PageImpl<>(List.of(motoDTO), pageable, 1);
        }
        return Page.empty();
    }


    // caching de limpeza
    @CacheEvict(value = {"buscarIdMoto", "PaginaMoto", "HistoricoPaginado"}, allEntries = true)
    public void limparCache(){
        System.out.println(">> Removendo arquivos de cache de Motos! <<");
    }


}
