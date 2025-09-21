package org.example.yardflow.service;


import org.example.yardflow.model.Moto;
import org.example.yardflow.model.Yardflow;
import org.example.yardflow.repository.MotoRepositorio;
import org.example.yardflow.repository.YardflowRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class YardflowCachingService {

    @Autowired
    private YardflowRepositorio yfR;

    @Autowired
    private MotoRepositorio mtR;

    @CacheEvict(value = "yfCahe", allEntries = true)
    public Yardflow criarNovoYardFlow(Yardflow yf) {
        return yfR.save(yf);
    }

    @Cacheable(value = "yfCache", key = "#ativar")
    public Yardflow ativarYardFlow(UUID id_yf, int id_moto){

        Yardflow yf = yfR.findById(id_yf).orElseThrow(()-> new IllegalArgumentException("YardFlow não localizado"));

        Moto moto = mtR.findById(id_moto).orElseThrow(()-> new IllegalArgumentException("Moto não localizada"));

        if (moto.getYardflow() != null){
            throw new IllegalArgumentException("Moto já possui uma yardflow ativo");
        }

        moto.setYardflow(yf);
        yf.setMoto(moto);
        yf.setDt_ultimo_acionamento(LocalDate.now());

        return yfR.save(yf);

    }

    @Cacheable(value = "yfCache", key = "#desativar")
    public Yardflow desativarYardFlow(UUID id_yf){
        Yardflow yf = yfR.findById(id_yf).orElseThrow(()-> new IllegalArgumentException("YardFlow não encontrado"));
        Moto moto = yf.getMoto();
        if (moto == null){
            throw new IllegalArgumentException("YardFlow não esta associado a nenhuma moto");
        }

        moto.setYardflow(null);
        yf.setMoto(null);

        return yfR.save(yf);
    }

    @Cacheable(value = "yfCache", key = "#id_yf")
    public Moto localizarMotoPorYardFlow(UUID id_yf){
        Yardflow yf = yfR.findById(id_yf).orElseThrow(()-> new IllegalArgumentException("YardFlow não encontrado"));

        return yf.getMoto();
    }

    @CacheEvict(value = "yfCache", allEntries = true)
    public void removerYardFlow(UUID id_yf){
        if (!yfR.existsById(id_yf)){
            throw new IllegalArgumentException("YardFlow não encontrado");
        }
        yfR.deleteById(id_yf);
    }

    @CacheEvict(value = "yfCache", allEntries = true)
    public void limparCache(){
        System.out.println(" Removendo arquivos de cache de YardFlow! ");

    }

}

