package org.example.yardflow;

import org.example.yardflow.model.RegistroCheckInOut;
import org.example.yardflow.service.PatioCachingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class YardFlowApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void deveCalcularPeriodoComEntradaESaida() {
        RegistroCheckInOut registro = new RegistroCheckInOut();
        registro.setEntrada_patio(LocalDate.now().minusDays(3));
        registro.setSaida_patio(LocalDate.now());

        registro.calcularPeriodoPermanencia();

        assertEquals(3, registro.getPeriodo());
    }

    @Test
    void deveCalcularPeriodoComSaidaNula() {
        RegistroCheckInOut registro = new RegistroCheckInOut();
        registro.setEntrada_patio(LocalDate.now().minusDays(2));
        registro.setSaida_patio(null); // usuário não informou saída

        registro.calcularPeriodoPermanencia();

        assertEquals(2, registro.getPeriodo());
    }

    @Test
    void deveRetornarUmDiaQuandoEntradaIgualSaida() {
        RegistroCheckInOut registro = new RegistroCheckInOut();
        registro.setEntrada_patio(LocalDate.now());
        registro.setSaida_patio(LocalDate.now());

        registro.calcularPeriodoPermanencia();

        assertEquals(1, registro.getPeriodo());
    }

    @Test
    void deveLancarExcecaoQuandoEntradaNula() {
        RegistroCheckInOut registro = new RegistroCheckInOut();

        assertThrows(IllegalStateException.class, registro::calcularPeriodoPermanencia);
    }

    @Test
    void deveLancarExcecaoQuandoSaidaAntesDaEntrada() {
        RegistroCheckInOut registro = new RegistroCheckInOut();
        registro.setEntrada_patio(LocalDate.now());
        registro.setSaida_patio(LocalDate.now().minusDays(1));

        assertThrows(IllegalArgumentException.class, registro::calcularPeriodoPermanencia);
    }



    @Autowired
    private PatioCachingService patioService;

    @Test
    void testarBuscaPorId() {
        var patio = patioService.buscarPatioPorId(1);
        assertNotNull(patio);
        System.out.println("Patio encontrado: " + patio.getSetor());
    }

}
