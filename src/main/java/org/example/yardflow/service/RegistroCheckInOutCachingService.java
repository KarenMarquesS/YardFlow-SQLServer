package org.example.yardflow.service;


import org.example.yardflow.model.RegistroCheckInOut;
import org.example.yardflow.projection.PermanenciaPorSetorModeloDTO;
import org.example.yardflow.repository.RegistroCheckInOutRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class RegistroCheckInOutCachingService {

    @Autowired
    private RegistroCheckInOutRepositorio rep;


    @Cacheable(value="inserir da entrada", key="dataEntrada")
    public boolean inserirDataEntrada(LocalDate dataEntrada) {
       return dataEntrada != null;
    }

    @Cacheable(value = "inserir data saida", key="dataSaida")
    public boolean inserirDataSaida(LocalDate dataSaida) {
      return dataSaida != null;
    }

    @Cacheable(value = "permanenciaSetorModelo", key = "{#pageable.pageNumber, #pageable.pageSize}")
    public Page<PermanenciaPorSetorModeloDTO> obterPermanenciasPorSetorModelo(Pageable pageable) {
        return rep.buscarPermanenciaPorSetorModelo(pageable);
    }

    @Cacheable(value = "registroEntrada", key = "#entrada")
    public RegistroCheckInOut buscarDataEntradaMoto(LocalDate entrada) {
        return rep.buscarDataEntradaMoto(entrada);
    }

    @Cacheable(value = "registroSaida", key = "#saida")
    public RegistroCheckInOut buscarDataSaidaMoto(LocalDate saida) {
        return rep.buscarDataSaidaMoto(saida);
    }


    @CacheEvict(value = {"obterPermanenciasPorSetorModelo, buscarDataEntradaMoto, buscarDataSaidaMoto"})
    public void deletarRegistro(){
        System.out.println(">> Removido arquivos do cache de Registros de Entrada e saída do Pátio! <<");
    }
}



