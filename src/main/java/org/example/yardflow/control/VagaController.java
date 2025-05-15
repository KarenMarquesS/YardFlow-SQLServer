package org.example.yardflow.control;


import org.example.yardflow.model.SetorEnum;
import org.example.yardflow.model.Vaga;
import org.example.yardflow.repository.VagaRepositorio;
import org.example.yardflow.service.VagaCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/vaga")
public class VagaController {

    @Autowired
    private VagaRepositorio vgRep;

    @Autowired
    private VagaCachingService vgCh;

    @GetMapping("/buscar/{idVaga}")
    public ResponseEntity<Vaga> buscarIdVaga(@PathVariable String idVaga){
        Optional<Vaga> vaga = vgRep.findById(idVaga);
        return vaga.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/ocupada")
    public ResponseEntity<List<Vaga>> listaDeVagasOcupadas(@RequestParam boolean ocupada){
        List<Vaga> vagas = vgRep.vagaOcupada(ocupada);
        if (vagas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(vagas);
    }

    @GetMapping("/setor")
    public ResponseEntity<List<Vaga>> buscaDeVagaSetor(@RequestParam SetorEnum setor){
        List<Vaga> vagas = vgRep.buscarVagaSetor(setor);
        if (vagas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(vagas);
      }



}
