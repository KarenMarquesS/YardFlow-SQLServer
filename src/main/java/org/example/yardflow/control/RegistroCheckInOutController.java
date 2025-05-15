package org.example.yardflow.control;


import org.example.yardflow.model.RegistroCheckInOut;
import org.example.yardflow.service.RegistroCheckInOutCachingService;
import org.example.yardflow.projection.PermanenciaPorSetorModeloDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/registrocheckinout")
public class RegistroCheckInOutController {

    @Autowired
    private RegistroCheckInOutCachingService regSer;


    @PostMapping("/entrada/{idMoto}")
    public ResponseEntity<String> inserirDataEntrada(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataEntrada) {

        boolean inserido = regSer.inserirDataEntrada(dataEntrada);
        if (inserido) {
            return ResponseEntity.ok("Data de entrada registrada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao registrar a data de entrada.");
        }
    }


    @PostMapping("/saida/{idMoto}")
    public ResponseEntity<String> inserirDataSaida(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataSaida) {

        boolean inserido = regSer.inserirDataSaida(dataSaida);
        if (inserido) {
            return ResponseEntity.ok("Data de saída registrada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao registrar a data de saída.");
        }
    }

    @GetMapping("/permanencia/{idMoto}")
    public ResponseEntity<Page<PermanenciaPorSetorModeloDTO>> obterPermanenciasPorSetorModelo(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<PermanenciaPorSetorModeloDTO> resultado = regSer.obterPermanenciasPorSetorModelo(pageable);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/buscarentrada/{idMoto}")
    public ResponseEntity<RegistroCheckInOut> buscarEntradaPorData(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataEntrada) {

        RegistroCheckInOut registro = regSer.buscarDataEntradaMoto(dataEntrada);
        if (registro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(registro);
    }

    @GetMapping("/buscarsaida/{id}")
    public ResponseEntity<RegistroCheckInOut> buscarSaidaPorData(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataSaida) {

        RegistroCheckInOut registro = regSer.buscarDataSaidaMoto(dataSaida);
        if (registro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(registro);
    }

    @DeleteMapping("/desativarregistro/{id}")
    public ResponseEntity<String> deletarRegistro() {
        regSer.deletarRegistro();
        return ResponseEntity.ok("Cache limpo com sucesso.");
    }
}


