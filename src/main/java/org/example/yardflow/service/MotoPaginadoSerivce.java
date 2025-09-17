package org.example.yardflow.service;


import org.example.yardflow.dto.MotoDTO;
import org.example.yardflow.model.Moto;
import org.example.yardflow.repository.MotoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MotoPaginadoSerivce {

    @Autowired
    private MotoRepositorio repMt;

    @Autowired
    private ModelMapper mM;


    // Páginas de motos (paginadas, chaveada pelo id e paginação)
    @Transactional(readOnly = true)
    public Page<MotoDTO> getAllMotosPaginado(int id_moto, int page, int size){
        Pageable pageable = PageRequest.of(page, size);

        Optional<Moto> mtOp = Optional.ofNullable(repMt.findById(id_moto));
        if (mtOp.isPresent()){
            MotoDTO motoDTO = mM.map(mtOp.get(), MotoDTO.class);
            return new PageImpl<>(List.of(motoDTO), pageable, 1);
        }
        return Page.empty();
    }
}
