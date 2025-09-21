package org.example.yardflow.control.api;

import jakarta.validation.Valid;
import org.example.yardflow.dto.MotoDTO;

import org.example.yardflow.service.MotoCachingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value="/moto")
public class MotoController {

    @Autowired
    private MotoCachingService mtS;


    @GetMapping
    public ResponseEntity<Page<MotoDTO>> findAll(Pageable pageable) {
        Page<MotoDTO> motos = mtS.findAllPaginado(pageable);
        return ResponseEntity.ok(motos);
    }

    @GetMapping("/{id_moto}")
    public ResponseEntity<MotoDTO> findById(@PathVariable Integer id_moto) {
        return ResponseEntity.ok(mtS.findById(id_moto));
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<MotoDTO> findByPlaca(@PathVariable String placa) {
        return ResponseEntity.ok(mtS.findByPlaca(placa));
    }

    @GetMapping("/chassi/{chassi}")
    public ResponseEntity<MotoDTO> findByChassi(@PathVariable String chassi) {
        return ResponseEntity.ok(mtS.findByChassi(chassi));
    }

    @PostMapping
    public ResponseEntity<MotoDTO> criarNovaMoto(@RequestBody @Valid MotoDTO motoDTO) {
        MotoDTO createdMoto = mtS.criarNovaMoto(motoDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id_moto}")
                .buildAndExpand(createdMoto.getId_moto())
                .toUri();
        return ResponseEntity.created(location).body(createdMoto);
    }

    @PutMapping("/{id_moto}")
    public ResponseEntity<MotoDTO> atualizarRegistroMoto(@PathVariable Integer id_moto, @RequestBody @Valid MotoDTO motoDTO) {
        MotoDTO updatedMoto = mtS.atualizarRegistroMoto(id_moto, motoDTO);
        return ResponseEntity.ok(updatedMoto);
    }

    @DeleteMapping("/{id_moto}")
    public ResponseEntity<Void> deletarRegistroMoto(@PathVariable Integer id_moto) {
        mtS.deletarRegistroMoto(id_moto);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }

    @DeleteMapping("/cache/limpar")
    public ResponseEntity<Void> limparCache() {
        mtS.limparCache();
        return ResponseEntity.noContent().build();
    }

}
