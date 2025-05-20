package org.example.yardflow.service;


import org.example.yardflow.model.Registro_check_in_out;
import org.example.yardflow.projection.PermanenciaPorSetorModeloDTO;
import org.example.yardflow.repository.Registro_check_in_outRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class Registro_check_in_outCachingService {

    @Autowired
    private Registro_check_in_outRepositorio rep;


    @Cacheable(value="inserir da entrada", key="data_entrada")
    public boolean inserirDataEntrada(LocalDate data_entrada) {
       return data_entrada != null;
    }

    @Cacheable(value = "inserir data saida", key="data_saida")
    public boolean inserirDataSaida(LocalDate data_saida) {
      return data_saida != null;
    }

    @Cacheable(value = "permanenciaSetorModelo", key = "{#pageable.pageNumber, #pageable.pageSize}")
    public Page<PermanenciaPorSetorModeloDTO> obterPermanenciasPorSetorModelo(Pageable pageable) {
        return rep.buscarPermanenciaPorSetorModelo(pageable);
    }

    @Cacheable(value = "registroEntrada", key = "#entrada")
    public Registro_check_in_out buscarDataEntradaMoto(LocalDate data_entrada) {
        return rep.buscarDataEntradaMoto(data_entrada);
    }

    @Cacheable(value = "registroSaida", key = "#saida")
    public Registro_check_in_out buscarDataSaidaMoto(LocalDate data_saida) {
        return rep.buscarDataSaidaMoto(data_saida);
    }


    @CacheEvict(value = {"obterPermanenciasPorSetorModelo, buscarDataEntradaMoto, buscarDataSaidaMoto"})
    public void deletarRegistro(){
        System.out.println(">> Removido arquivos do cache de Registros de Entrada e saída do Pátio! <<");
    }
}



