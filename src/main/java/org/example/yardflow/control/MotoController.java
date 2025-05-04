package org.example.yardflow.control;


import org.example.parkflow.model.Moto;
import org.example.parkflow.repository.MotoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/api/moto")
public class MotoController {

    @Autowired
    private MotoRepositorio mR;

    @GetMapping("/TodasMotos")
    public List<Moto> listarTodas(){
        return mR.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> buscarPorId(@PathVariable long id){
        return mR.findById(id).map(ResponseEntity:: ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/RegistroEntrada")
    public Moto registroEntrada(@RequestBody Moto moto){
        return mR.save(moto);
    }

//    @PutMapping("{id}")
//    public ResponseEntity<Moto> editar(@PathVariable long id, @RequestBody Moto moto){
//        return;
//    }



}
