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
    @Cacheable(value = "motoCache", key ="'id:' + #id_moto")
    public Moto findByIdMoto(int id_moto) {
        return repMt.findByIdMoto(id_moto);
    }


    @Cacheable(value = "motoCache", key="'placa:' + #placa")
    public Moto findByPlaca(String placa) {
        return repMt.findByPlaca(placa);
    }

    @Cacheable(value = "motoCache", key="'chassi', key= 'chassi:' + #chassi")
    public Moto findByChassi(String chassi) {
        return repMt.findByChassi(chassi);
    }

    // Atualiza/insere moto
    @CacheEvict(value = "motoCache", key = "'id:' + #moto.id_moto")
    public Moto salvarOuAtualizar(Moto moto){
        return repMt.save(moto);
    }

    @Cacheable(value="motoCache", key = "'historico:' + #id_moto")
    public String mostrarHistoricoMoto(int id_moto){
        return repMt.mostrarHistoricoMoto(id_moto);
    }

    // Páginas de motos (paginadas, chaveada pelo id e paginação)
    @Cacheable(value = "motoCache", key = "'page:' + #id_moto + ':' + #page + ':' + #size")
    public Page<MotoDTO> getAllMotosPaginado(int id_moto, int page, int size){
        Pageable pageable = PageRequest.of(page, size);

        Optional<Moto> mtOp = repMt.findById(id_moto);
        if (mtOp.isPresent()){
            MotoDTO motoDTO = mM.map(mtOp.get(), MotoDTO.class);
            return new PageImpl<>(List.of(motoDTO), pageable, 1);
        }
        return Page.empty();
    }

    // Desativa moto
    @CacheEvict(value = "motoCache", key = "'id:' + #id_moto")
    public void desativarMoto(int id_moto){
        repMt.findById(id_moto).ifPresent(moto -> {
            moto.setAtivo(false);
            repMt.save(moto);
        });
    }

    // caching de limpeza
    @CacheEvict(value = "motoCache", allEntries = true)
    public void limparCache(){
        System.out.println(">> Removendo arquivos de cache de Motos! <<");
    }


}
