package org.example.yardflow.service;

import org.example.yardflow.repository.Registro_check_in_outRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Registro_check_in_outCalculoService {

    @Autowired
    private Registro_check_in_outRepositorio repRg;

    @Cacheable(value = "registroCache", key = "'permanencia:' + #id_registro")
    public Optional<Integer> calcularPeriodoPermanencia(int id_registro) {
        return repRg.findById(id_registro).map(registro -> {
            registro.calcularPeriodoPermanencia();
            repRg.save(registro);
            return registro.getPeriodo();
        });
    }
}
