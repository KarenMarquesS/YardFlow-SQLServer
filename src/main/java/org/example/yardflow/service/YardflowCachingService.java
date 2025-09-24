package org.example.yardflow.service;


import org.example.yardflow.model.Moto;
import org.example.yardflow.model.Yardflow;
import org.example.yardflow.repository.MotoRepositorio;
import org.example.yardflow.repository.YardflowRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;

import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class YardflowCachingService {

    @Autowired
    private YardflowRepositorio yfRep;

    @Autowired
    private MotoRepositorio mtR;

    @CacheEvict(value = "yfCahe", allEntries = true)
    public Yardflow criarNovoYardFlow(Yardflow yf) {
        return yfRep.save(yf);
    }


    @Cacheable(value = "yfCache", key = "#ativar")
    public Yardflow ativarYardFlow(int idyf, int idmoto){

        Yardflow yf = yfRep.findById(idyf).orElseThrow(()-> new IllegalArgumentException("YardFlow não localizado"));

        Moto moto = mtR.findById(idmoto).orElseThrow(()-> new IllegalArgumentException("Moto não localizada"));

        if (moto.getYardflow() != null){
            throw new IllegalArgumentException("Moto já possui uma yardflow ativo");
        }

        moto.setYardflow(yf);
        yf.setMoto(moto);
        yf.setDtultimoacionamento(LocalDate.now());

        return yfRep.save(yf);
    }

    @Cacheable(value = "yfCache", key = "'serial' + #serial")
    public Optional<Yardflow> buscarSerial ( String serial) {
        return yfRep.findBySerial(serial);
    }

    @Cacheable(value = "yfCache", key = "'acionamento' + #dt_ultimo_acionamento")
    public List<Yardflow> buscarDtUltimoAcionamento (LocalDate dt_ultimo_acionamento) {
        return yfRep.findByDtUltimoAcionamento(LocalDateTime.from(dt_ultimo_acionamento));
    }

    @Cacheable(value = "yfCache", key = "#desativar")
    public Yardflow desativarYardFlow(int idyf){
        Yardflow yf = yfRep.findById(idyf).orElseThrow(()-> new IllegalArgumentException("YardFlow não encontrado"));
        Moto moto = yf.getMoto();
        if (moto == null){
            throw new IllegalArgumentException("YardFlow não esta associado a nenhuma moto");
        }

        moto.setYardflow(null);
        yf.setMoto(null);

        return yfRep.save(yf);
    }

    @Cacheable(value = "yfCache", key = "#idyf")
    public Moto localizarMotoPorYardFlow(int idyf){
        Yardflow yf = yfRep.findById(idyf).orElseThrow(()-> new IllegalArgumentException("YardFlow não encontrado"));

        return yf.getMoto();
    }

    @CacheEvict(value = "yfCache", allEntries = true)
    public void removerYardFlow(int idyf){
        if (!yfRep.existsById(idyf)){
            throw new IllegalArgumentException("YardFlow não encontrado");
        }
        yfRep.deleteById(idyf);
    }

    @CacheEvict(value = "yfCache", allEntries = true)
    public void limparCache(){
        System.out.println(" Removendo arquivos de cache de YardFlow! ");

    }

}

