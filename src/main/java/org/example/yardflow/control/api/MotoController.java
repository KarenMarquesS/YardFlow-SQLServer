package org.example.yardflow.control.api;

import jakarta.validation.Valid;
import org.example.yardflow.dto.MotoDTO;

import org.example.yardflow.model.Moto;
import org.example.yardflow.service.MotoCachingService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.NoSuchElementException;


@RestController
@RequestMapping(value="/apimoto")
public class MotoController {

    @Autowired
    private MotoCachingService mtS;

    @Autowired
    private ModelMapper mm;


    // não fiz um endpoint - estou avaliando
    @GetMapping
    public ResponseEntity<Page<MotoDTO>> findAll(Pageable pageable) {
        Page<MotoDTO> motos = mtS.findAllPaginado(pageable);
        return ResponseEntity.ok(motos);
    }

    @GetMapping("/{idmoto}")
    public ResponseEntity<MotoDTO> findById(@PathVariable Long idmoto) {
        try {
            Moto moto = mtS.findById(idmoto)
                    .orElseThrow(() -> new NoSuchElementException("Moto não encontrada: " + idmoto));
            MotoDTO dto = mm.map(moto, MotoDTO.class);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<MotoDTO> findByPlaca(@PathVariable String placa) {
        try {
            MotoDTO dto = mtS.findByPlaca(placa);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/chassi/{chassi}")
    public ResponseEntity<MotoDTO> findByChassi(@PathVariable String chassi) {
        try {
            MotoDTO dto = mtS.findByChassi(chassi);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/historico/{idmoto}")
    public ResponseEntity<MotoDTO> buscarHistoricoPorMoto(@PathVariable Long idmoto) {
        try {
            MotoDTO dto = mtS.buscarHistorico(idmoto);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/novamoto")
    public ResponseEntity<MotoDTO> criarNovaMoto(@RequestBody @Valid MotoDTO motoDTO) {
        MotoDTO createdMoto = mtS.criarNovaMoto(motoDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idmoto}")
                .buildAndExpand(createdMoto.getIdmoto())
                .toUri();
        return ResponseEntity.created(location).body(createdMoto);
    }

    @PutMapping("/atualizar/{idmoto}")
    public ResponseEntity<MotoDTO> atualizarRegistroMoto(@PathVariable Long idmoto, @RequestBody @Valid MotoDTO motoDTO) {
        MotoDTO updatedMoto = mtS.atualizarRegistroMoto(idmoto, motoDTO);
        return ResponseEntity.ok(updatedMoto);
    }

    @DeleteMapping("/deletar/{idmoto}")
    public ResponseEntity<Void> deletarRegistroMoto(@PathVariable Long idmoto) {
        boolean ok = mtS.deletarRegistroMoto(idmoto);
        return ok ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/cache/limpar")
    public ResponseEntity<Void> limparCache() {
        mtS.limparCache();
        return ResponseEntity.noContent().build();
    }

}
