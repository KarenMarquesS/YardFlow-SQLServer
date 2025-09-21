package org.example.yardflow.service;

import org.example.yardflow.dto.RegistroPermanenciaDTO;
import org.example.yardflow.model.Moto;
import org.example.yardflow.model.Registro_check_in_out;

import org.example.yardflow.repository.MotoRepositorio;
import org.example.yardflow.repository.Registro_check_in_outRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Registro_check_in_outCachingService {

    @Autowired
    private Registro_check_in_outRepositorio rgR;

    @Autowired
    private MotoRepositorio mtR;



    @CacheEvict(value = "registroCache", allEntries = true)
    public Registro_check_in_out inserirDataEntrada(int id_moto, LocalDate entrada) {
        Moto moto = mtR.findById(id_moto).orElseThrow(() ->
                new IllegalArgumentException("Moto não encontrada com id: " + id_moto));

        rgR.findTopByMoto_IdAndSaidaPatioIsNullOrderByEntradaPatioDesc(id_moto)
                .ifPresent(r -> { throw new IllegalStateException("Já existe um registro aberto para essa moto."); });

        Registro_check_in_out reg = new Registro_check_in_out();
        reg.setMoto(moto);
        reg.setEntrada_patio(entrada);
        reg.setPeriodo(1);
        return rgR.save(reg);
    }


    @CacheEvict(value = "registroCache", allEntries = true)
    public Registro_check_in_out inserirDataSaida(int id_moto, LocalDate saida) {
        Registro_check_in_out reg = rgR.findTopByMoto_IdAndSaidaPatioIsNullOrderByEntradaPatioDesc(id_moto)
                .orElseThrow(() -> new IllegalArgumentException("Nenhum registro aberto encontrado para a moto id: " + id_moto));

        if (saida.isBefore(reg.getEntrada_patio())) {
            throw new IllegalArgumentException("Data de saída não pode ser anterior à entrada.");
        }

        reg.setSaida_patio(saida);
        int periodo = calcularPeriodoEntre(reg.getEntrada_patio(), saida);
        reg.setPeriodo(periodo);
        return rgR.save(reg);
    }

    @Cacheable(value = "registroCache", key = "'entrada:' + #entrada_patio")
    public List<Registro_check_in_out> buscarPorEntrada(LocalDate entrada_patio) {
        return rgR.findAllByEntradaPatio(entrada_patio);
    }

    @Cacheable(value = "registroCache", key = "'saida:' + #saida_patio")
    public List<Registro_check_in_out> buscarPorSaida(LocalDate saida_patio) {
        return rgR.findAllBySaidaPatio(saida_patio);
    }


    // Calcula permanência (se existir saida usa saida, senão agora)
    @Cacheable(value = "registroCache", key = "'permanencia:moto:' + #id_moto")
    public int calcularPermanenciaPorIdMoto(int id_moto) {
        // tenta primeiro registro aberto, senão o último registro existente
        Registro_check_in_out reg = rgR.findTopByMoto_IdAndSaidaPatioIsNullOrderByEntradaPatioDesc(id_moto)
                .orElseGet(() -> rgR.findTopByMoto_IdOrderByEntradaPatioDesc(id_moto)
                        .orElseThrow(() -> new IllegalArgumentException("Registro não encontrado para moto id: " + id_moto)));

        LocalDate saida = reg.getSaida_patio();
        return calcularPeriodoEntre(reg.getEntrada_patio(), saida);
    }

    private int calcularPeriodoEntre(LocalDate entrada, LocalDate saida) {
        if (entrada == null) throw new IllegalArgumentException("Data de entrada é obrigatória.");
        LocalDate fim = (saida != null) ? saida : LocalDate.now();
        if (fim.isBefore(entrada)) throw new IllegalArgumentException("Data de saída anterior à entrada.");
        long dias = ChronoUnit.DAYS.between(entrada, fim);
        return (int) Math.max(dias, 1);
    }

    // Lista todos os registros com entrada e retorna paginado/ordenado pela permanência (desc)
    public Page<RegistroPermanenciaDTO> listarPorPermanenciaOrdenada(Pageable pageable) {
        List<RegistroPermanenciaDTO> all = rgR.findByEntradaPatioIsNotNull().stream()
                .map(r -> {
                    int periodo = calcularPeriodoEntre(r.getEntrada_patio(), r.getSaida_patio());
                    Integer id_moto = (r.getMoto() != null) ? r.getMoto().getId_moto() : null;
                    String modelo = (r.getMoto() != null) ? r.getMoto().getModelo().getDescricao() : null;
                    return new RegistroPermanenciaDTO();
                })
                .sorted(Comparator.comparingInt(RegistroPermanenciaDTO::getPeriodo).reversed()) // maior -> menor
                .collect(Collectors.toList());

        final int start = (int) pageable.getOffset();
        final int end = Math.min(start + pageable.getPageSize(), all.size());
        List<RegistroPermanenciaDTO> content = (start <= end) ? all.subList(start, end) : List.of();

        return new PageImpl<>(content, pageable, all.size());
    }


    @CacheEvict(value = "registroCache", allEntries = true)
    public void limparCache(){
        System.out.println(" Removendo arquivos de cache dos Registros ");

    }
}



