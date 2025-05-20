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

    @GetMapping("/buscar/{id_vaga}")
    public ResponseEntity<Vaga> buscarIdVaga(@PathVariable int id_vaga){
        Optional<Vaga> vaga = vgRep.findById(id_vaga);
        return vaga.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/ocupada")
    public ResponseEntity<List<Vaga>> listaDeVagasOcupadas(@RequestParam boolean ocupada){
        List<Vaga> vaga = vgRep.vagaOcupada(ocupada);
        if (vaga.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(vaga);
    }

    @GetMapping("/setor")
    public ResponseEntity<List<Vaga>> buscaDeVagaSetor(@RequestParam SetorEnum setor){
        List<Vaga> vaga = vgRep.buscarVagaSetor(setor);
        if (vaga.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(vaga);
      }



}
