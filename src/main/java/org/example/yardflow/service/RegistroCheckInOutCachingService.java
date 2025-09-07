package org.example.yardflow.service;


import org.example.yardflow.model.RegistroCheckInOut;
import org.example.yardflow.projection.PermanenciaPorSetorModeloDTO;
import org.example.yardflow.repository.RegistroCheckInOutRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class RegistroCheckInOutCachingService {

    @Autowired
    private RegistroCheckInOutRepositorio rep;


    public boolean inserirDataEntrada(LocalDate dataEntrada) {
        RegistroCheckInOut registro = new RegistroCheckInOut();
        registro.setEntrada_patio(dataEntrada);
        salvarRegistroEntradaSaida(registro);
        return true;
    }

    public boolean inserirDataSaida(LocalDate dataSaida) {
        RegistroCheckInOut registro = rep.buscarDataSaidaMoto(dataSaida).orElse(new RegistroCheckInOut());
        registro.setSaida_patio(dataSaida);
        salvarRegistroEntradaSaida(registro);
        return true;
    }

    @CachePut(value = "registroCache", key = "#registro.id_registro")
    public RegistroCheckInOut salvarRegistroEntradaSaida(RegistroCheckInOut registro){
        registro.calcularPeriodoPermanencia();
        return rep.save(registro);
    }

    @Cacheable(value = "registroCache", key = "'permanencia:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public Page<PermanenciaPorSetorModeloDTO> obterPermanenciasPorSetorModelo(Pageable pageable) {
        return rep.buscarPermanenciaPorSetorModelo(pageable);
    }

    @Cacheable(value = "registroCache", key = "#entrada")
    public Optional<RegistroCheckInOut> buscarDataEntradaMoto(LocalDate data_entrada) {
        return rep.buscarDataEntradaMoto(data_entrada);
    }

    @Cacheable(value = "registroCache", key = "#saida")
    public Optional<RegistroCheckInOut> buscarDataSaidaMoto(LocalDate data_saida) {
        return rep.buscarDataSaidaMoto(data_saida);
    }

    @Cacheable(value = "registroCache", key = "'permanencia:' + #id_registro")
    public Optional<Integer> calcularPeriodoPermanencia(int id_registro) {
        return rep.findById(id_registro).map(registro -> {
            registro.calcularPeriodoPermanencia();
            rep.save(registro);
            return registro.getPeriodo();
        });
    }


    @CacheEvict(value = "registroCache", allEntries = true)
    public void deletarRegistro(){
        System.out.println(">> Removido arquivos do cache de Registros de Entrada e saída do Pátio! <<");
    }
}



