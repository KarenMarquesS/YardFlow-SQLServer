package org.example.yardflow.control;


import org.example.yardflow.DTO.MotoDTO;
import org.example.yardflow.model.Moto;
import io.swagger.v3.oas.annotations.Operation;
import org.example.yardflow.repository.MotoRepositorio;
import org.example.yardflow.service.MotoCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.Optional;

@RestController
@RequestMapping(value="/api/moto")
public class MotoController {

    @Autowired
    private MotoRepositorio repM;

    @Autowired
    private MotoCachingService servMt;


    @GetMapping("/{id}")
    public ResponseEntity<Moto> buscarIdMoto(@PathVariable int idMoto){
        Optional<Moto> moto = servMt.findById(idMoto);
        return moto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(description = "Este endpoint irá realizar as inserções das informações refentes a Moto", tags="Inserir " +
            "Dados", summary="Irá inserir os dados da Moto")
    @PostMapping(value = "/inserir")
    public Moto InserirMoto(@RequestBody Moto moto){
        repM.save(moto);
        servMt.limparCache();
        return moto;
    }

    @GetMapping(value = "/historico")
    public ResponseEntity<Page<MotoDTO>> historicoPaginado(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "2") int size){

        PageRequest req = PageRequest.of(page, size);
        Page<MotoDTO> historicoPaginado = servMt.paginar(req);
        return ResponseEntity.ok(historicoPaginado);
    }


    @PutMapping("{/id}")
    public ResponseEntity<Moto> atualizarMoto(@PathVariable int idMoto, @RequestBody Moto motoAtualizada){
        return repM.findById(idMoto).map(moto -> {
            moto.setIdMoto(motoAtualizada.getIdMoto());
            moto.setModelo(motoAtualizada.getModelo());
            moto.setChassi(motoAtualizada.getChassi());
            moto.setPlaca(motoAtualizada.getPlaca());
            moto.setNMotor(motoAtualizada.getNMotor());
            moto.setCliente(motoAtualizada.getCliente());

            return ResponseEntity.ok(repM.save(moto));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("{/id}/historico")
    public ResponseEntity<Moto> atualizarHistoricoMoto(@PathVariable int idMoto, @RequestBody Moto motoHistoricoAtualizado){
        return repM.findById(idMoto).map(moto -> {
            moto.setHistorico(motoHistoricoAtualizado.getHistorico());

            return ResponseEntity.ok(repM.save(moto));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desativarMoto(@PathVariable int id) {
        Optional<Moto> optionalMoto = repM.findById(id);
        if (optionalMoto.isPresent()) {
            Moto moto = optionalMoto.get();
            moto.setAtivo(false);
            repM.save(moto);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
