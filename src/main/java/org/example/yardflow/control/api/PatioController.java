package org.example.yardflow.control.api;

import org.example.yardflow.model.Patio;
import org.example.yardflow.service.PatioCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patio")
public class PatioController {

    @Autowired
    private PatioCachingService ptSrv;

    //inserir patio
    //atualilzar patio
    // via cep



    // Mostrar quantidade de vagas
//    @GetMapping("/quantidadevagas/{qtd_vagas}")
//    public ResponseEntity<List<Patio>> mostrarQtdVagas(@PathVariable("qtd_vagas") int qtd_vagas) {
//        List<Patio> patios = ptSrv.mostrarQtdVagas(qtd_vagas);
//
//        return ResponseEntity.ok(patios);
//    }


    // Deletar pátio
//    @DeleteMapping("/{id_patio}")
//    public ResponseEntity<Void> deletarPatio(@PathVariable int id_patio) {
//        ptSrv.deletarPatio(id_patio);
//        return ResponseEntity.noContent().build();
//    }


    @DeleteMapping("/limparcache")
    public ResponseEntity<Void> limparCache() {
        ptSrv.limparCache();
        return ResponseEntity.noContent().build();
    }
}

