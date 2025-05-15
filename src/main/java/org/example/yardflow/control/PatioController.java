package org.example.yardflow.control;

import org.example.yardflow.model.Patio;
import org.example.yardflow.model.SetorEnum;
import org.example.yardflow.model.Vaga;
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

    // Buscar pátio por setor
    @GetMapping("/setor/{setor}")
    public ResponseEntity<Patio> buscarPorSetor(@PathVariable("setor") SetorEnum setor) {
        return ptSrv.buscarPorSetor(setor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar pátio por ID da vaga
    @GetMapping("/vaga/{idVaga}")
    public ResponseEntity<Patio> buscarPorIdVaga(@PathVariable("idVaga") String idVaga) {
        return ptSrv.buscarPorIdVagas(idVaga)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Mostrar quantidade de vagas igual a um número específico
    @GetMapping("/quantidadevagas/{qtdVagas}")
    public ResponseEntity<List<Vaga>> mostrarQtdVagas(@PathVariable("qtdVagas") int qtdVagas) {
        List<Vaga> vagas = ptSrv.mostrarQtdVagas(qtdVagas);
        return ResponseEntity.ok(vagas);
    }

    // Mostrar quantidade de vagas ocupadas por setor
    @GetMapping("/ocupada")
    public ResponseEntity<List<SetorEnum>> mostrarVagasOcupadasPorSetor() {
        List<SetorEnum> resultados = ptSrv.mostrarVagaOcupadaPorSetor();
        return ResponseEntity.ok(resultados);
    }


    @DeleteMapping("/limparcache")
    public ResponseEntity<Void> limparCache() {
        ptSrv.limparCache();
        return ResponseEntity.noContent().build();
    }
}

