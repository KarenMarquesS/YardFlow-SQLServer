package org.example.yardflow.control;


import jakarta.validation.Valid;
import org.example.yardflow.dto.RegistroCheckInOutDTO;
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
import java.util.Optional;

@RestController
@RequestMapping("/registrocheckinout")
public class RegistroCheckInOutController {

    @Autowired
    private RegistroCheckInOutCachingService regSer;


    @PostMapping("/entrada/{id_moto}")
    public ResponseEntity<String> registrarEntrada(@PathVariable("id_moto") int id_moto,
                                                   @Valid @RequestBody RegistroCheckInOutDTO registroDTO){
        if (regSer.inserirDataEntrada(registroDTO.getEntrada_patio())) {
            return ResponseEntity.ok("Data de entrada registrada com sucesso.");
        }
        throw new IllegalArgumentException("Falha ao registrar a data de entrada.");
    }


    @PostMapping("/saida/{id_moto}")
    public ResponseEntity<String> registrarSaida(@PathVariable("id_moto") int id_moto,
                                                   @Valid @RequestBody RegistroCheckInOutDTO registroDTO) {
        if (regSer.inserirDataSaida(registroDTO.getSaida_patio())) {
            return ResponseEntity.ok("Data de saída registrada com sucesso.");
        }
        throw new IllegalArgumentException("Falha ao registrar a data de saída.");
    }

    @GetMapping("/permanencia")
    public ResponseEntity<Page<PermanenciaPorSetorModeloDTO>> listarPermanencias(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<PermanenciaPorSetorModeloDTO> resultado = regSer.obterPermanenciasPorSetorModelo(pageable);
        return ResponseEntity.ok(regSer.obterPermanenciasPorSetorModelo(PageRequest.of(page, size)));
    }

    @GetMapping("/entrada")
    public ResponseEntity<RegistroCheckInOut> buscarEntrada(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataEntrada) {
        return ResponseEntity.of(regSer.buscarDataEntradaMoto(dataEntrada));
    }

    @GetMapping("/saida")
    public ResponseEntity<RegistroCheckInOut> buscarSaida(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataSaida) {
        return ResponseEntity.of(regSer.buscarDataSaidaMoto(dataSaida));
    }

    @GetMapping("/permanencia/{id_registro}")
    public ResponseEntity<Integer> calcularPermanencia(@PathVariable int id_registro) {
        return ResponseEntity.of(regSer.calcularPeriodoPermanencia(id_registro));
    }


    @DeleteMapping("/desativarregistro/{id_moto}")
    public ResponseEntity<String> deletarRegistro() {
        regSer.deletarRegistro();
        return ResponseEntity.ok("Cache limpo com sucesso.");
    }
}


