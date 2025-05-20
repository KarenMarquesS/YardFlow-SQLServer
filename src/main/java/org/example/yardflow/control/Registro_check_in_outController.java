package org.example.yardflow.control;


import org.example.yardflow.model.Registro_check_in_out;
import org.example.yardflow.service.Registro_check_in_outCachingService;
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
public class Registro_check_in_outController {

    @Autowired
    private Registro_check_in_outCachingService regSer;


    @PostMapping("/entrada/{id_moto}")
    public ResponseEntity<String> inserirDataEntrada(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data_entrada) {

        boolean inserido = regSer.inserirDataEntrada(data_entrada);
        if (inserido) {
            return ResponseEntity.ok("Data de entrada registrada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao registrar a data de entrada.");
        }
    }


    @PostMapping("/saida/{id_moto}")
    public ResponseEntity<String> inserirDataSaida(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data_saida) {

        boolean inserido = regSer.inserirDataSaida(data_saida);
        if (inserido) {
            return ResponseEntity.ok("Data de saída registrada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao registrar a data de saída.");
        }
    }

    @GetMapping("/permanencia/{id_moto}")
    public ResponseEntity<Page<PermanenciaPorSetorModeloDTO>> obterPermanenciasPorSetorModelo(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<PermanenciaPorSetorModeloDTO> resultado = regSer.obterPermanenciasPorSetorModelo(pageable);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/buscarentrada/{id_moto}")
    public ResponseEntity<Registro_check_in_out> buscarEntradaPorData(
            @RequestParam("data_entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data_entrada) {

        Registro_check_in_out registro = regSer.buscarDataEntradaMoto(data_entrada);
        if (registro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(registro);
    }

    @GetMapping("/buscarsaida/{id}")
    public ResponseEntity<Registro_check_in_out> buscarSaidaPorData(
            @RequestParam("data_saida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data_saida) {

        Registro_check_in_out registro = regSer.buscarDataSaidaMoto(data_saida);
        if (registro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(registro);
    }

    @DeleteMapping("/desativarregistro/{id_moto}")
    public ResponseEntity<String> deletarRegistro() {
        regSer.deletarRegistro();
        return ResponseEntity.ok("Cache limpo com sucesso.");
    }
}


