package org.example.yardflow.control.api;


import jakarta.validation.Valid;
import org.example.yardflow.dto.RegistroPermanenciaDTO;
import org.example.yardflow.dto.Registro_check_in_outDTO;
import org.example.yardflow.model.Registro_check_in_out;
import org.example.yardflow.service.Registro_check_in_outCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/registrocheckinout")
public class Registro_check_in_outController {

    @Autowired
    private Registro_check_in_outCachingService rgS;


    @PostMapping("/entrada/{id_moto}")
    public ResponseEntity<Registro_check_in_outDTO> registrarEntrada(@PathVariable("id_moto") int id_moto,
                                                                     @Valid @RequestBody Registro_check_in_outDTO dto) {
        Registro_check_in_out reg = rgS.inserirDataEntrada(id_moto, dto.getEntrada_patio());
        Registro_check_in_outDTO resposta = new Registro_check_in_outDTO(reg.getId_registro(), reg.getEntrada_patio(),
                reg.getSaida_patio(), reg.getPeriodo(), reg.getSetor(), null);
        return ResponseEntity.ok(resposta);
    }


    @PostMapping("/saida/{id_moto}")
    public ResponseEntity<Registro_check_in_outDTO> registrarSaida(@PathVariable("id_moto") int id_moto,
                                                                @Valid @RequestBody Registro_check_in_outDTO dto) {
        Registro_check_in_out reg = rgS.inserirDataSaida(id_moto, dto.getSaida_patio());
        Registro_check_in_outDTO resposta = new Registro_check_in_outDTO(reg.getId_registro(), reg.getEntrada_patio(),
                reg.getSaida_patio(), reg.getPeriodo(), reg.getSetor(), null);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/entrada")
    public ResponseEntity<List<Registro_check_in_out>> buscarEntrada(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada_patio) {
        List<Registro_check_in_out> registros = rgS.buscarPorEntrada(entrada_patio);

        if (registros == null || registros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(registros);
    }


    @GetMapping("/permanencia/moto/{id_moto}")
    public ResponseEntity<Integer> permanenciaPorMoto(@PathVariable("id_moto") int id_moto) {
        int dias = rgS.calcularPermanenciaPorIdMoto(id_moto);
        return ResponseEntity.ok(dias);
    }


    @GetMapping("/lista/por_permanencia")
    public ResponseEntity<Page<RegistroPermanenciaDTO>> listarPorPermanencia(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RegistroPermanenciaDTO> resultado = rgS.listarPorPermanenciaOrdenada(pageable);
        return ResponseEntity.ok(resultado);
    }

    // Limpar cache (delete sem corpo)
    @DeleteMapping("/cache")
    public ResponseEntity<String> limparCache() {
        rgS.limparCache();
        return ResponseEntity.ok("Cache limpo com sucesso.");
    }



}


