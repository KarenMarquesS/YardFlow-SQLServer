package org.example.yardflow.control;


import org.example.yardflow.dto.VagaDTO;
import org.example.yardflow.model.EnumSetor;
import org.example.yardflow.model.Vaga;
import org.example.yardflow.service.VagaCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/vaga")
public class VagaController {

    @Autowired
    private VagaCachingService vgC;


    public ResponseEntity<VagaDTO> criarVaga(@RequestBody VagaDTO vgDTO){
        VagaDTO vagaCriada = vgC.criarVaga(vgDTO);
        return ResponseEntity.ok(vagaCriada);
    }


    @GetMapping("/{id_vaga}")
    public ResponseEntity<VagaDTO> buscarIdVaga(@PathVariable int id_vaga){
        return vgC.findByIdVaga(id_vaga)
                .map(ResponseEntity::ok)
                .orElseThrow(()-> new IllegalArgumentException(">> Nenhuma vaga encontrada com o ID informado <<"));
    }

    @GetMapping("/ocupada")
    public ResponseEntity<List<VagaDTO>> listaDeVagasOcupadas(@RequestParam boolean ocupada){
        List<VagaDTO> vaga = vgC.vagaOcupada(ocupada);
        if (vaga.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(vaga);
    }

    @GetMapping("/setor")
    public ResponseEntity<List<VagaDTO>> buscaDeVagaSetor(@RequestParam EnumSetor setor){
        List<VagaDTO> vaga = vgC.findVagaBySetor(setor);
        if (vaga.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(vaga);
      }

    @DeleteMapping("/{id_vaga}")
    public ResponseEntity<Void> deletarVaga(@PathVariable int id_vaga) {
        vgC.deletarVaga(id_vaga);
        return ResponseEntity.noContent().build();
    }

}
