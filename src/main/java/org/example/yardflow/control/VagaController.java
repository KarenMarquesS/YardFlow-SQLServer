package org.example.yardflow.control;


import org.example.yardflow.dto.VagaDTO;
import org.example.yardflow.model.SetorEnum;
import org.example.yardflow.model.Vaga;
import org.example.yardflow.repository.VagaRepositorio;
import org.example.yardflow.service.VagaCachingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/vaga")
public class VagaController {

    @Autowired
    private VagaCachingService vgC;

    @GetMapping("/buscar/{id_vaga}")
    public ResponseEntity<List<VagaDTO>> buscarIdVaga(@PathVariable int id_vaga){
        List<VagaDTO> vaga = vgC.buscarIdVaga(id_vaga);
        if(vaga.isEmpty()){
            throw new IllegalArgumentException(">> Nenhuma vaga encontrada com o ID informado <<");
        }
        return ResponseEntity.ok(vaga);
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
    public ResponseEntity<List<VagaDTO>> buscaDeVagaSetor(@RequestParam SetorEnum setor){
        List<VagaDTO> vaga = vgC.buscarVagaSetor(setor);
        if (vaga.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(vaga);
      }



}
