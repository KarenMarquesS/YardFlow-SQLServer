package org.example.yardflow.control;


import org.example.yardflow.dto.MotoDTO;
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
@RequestMapping(value="/moto")
public class MotoController {

    @Autowired
    private MotoRepositorio repM;

    @Autowired
    private MotoCachingService servMt;


    @GetMapping("/buscar{id_moto}")
    public ResponseEntity<Moto> buscarIdMoto(@PathVariable int id_moto){
        Optional<Moto> moto = servMt.findById(id_moto);
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

    @Operation(description = "Neste endpoint estará todo o historico de manuteção e reparos feitos na moto pela Mottu", tags="Historico"
                , summary="Histórico da moto na Mottu"    )
    @GetMapping(value = "/historico/{id_moto}")
    public ResponseEntity<Page<MotoDTO>> historicoPaginado(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "2") int size){

        PageRequest req = PageRequest.of(page, size);
        Page<MotoDTO> historicoPaginado = servMt.getAllMotosPaginado(req);
        return ResponseEntity.ok(historicoPaginado);
    }


    @PutMapping("/atualizar/{id_moto}")
    public ResponseEntity<Moto> atualizarMoto(@PathVariable int id_moto, @RequestBody Moto motoAtualizada){
        return repM.findById(id_moto).map(moto -> {
            moto.setModelo(motoAtualizada.getModelo());
            moto.setChassi(motoAtualizada.getChassi());
            moto.setPlaca(motoAtualizada.getPlaca());
            moto.setCliente(motoAtualizada.getCliente());

            return ResponseEntity.ok(repM.save(moto));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/atualizarhistorico/{id_moto}")
    public ResponseEntity<Moto> atualizarHistoricoMoto(@PathVariable int id_moto, @RequestBody Moto motoHistoricoAtualizado){
        return repM.findById(id_moto).map(moto -> {
            moto.setHistorico(motoHistoricoAtualizado.getHistorico());

            return ResponseEntity.ok(repM.save(moto));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/desativar/{id_moto}")
    public ResponseEntity<Void> desativarMoto(@PathVariable int id_moto) {
        Optional<Moto> optionalMoto = repM.findById(id_moto);
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
