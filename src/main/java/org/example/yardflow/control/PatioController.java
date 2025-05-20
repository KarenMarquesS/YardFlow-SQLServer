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
    @GetMapping("/vaga/{id_vaga}")
    public ResponseEntity<Patio> buscarPorIdVaga(@PathVariable("id_vaga") String id_vaga) {
        return ptSrv.buscarPorIdVagas(id_vaga)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Mostrar quantidade de vagas igual a um número específico
    @GetMapping("/quantidadevagas/{qtdVagas}")
    public ResponseEntity<List<Vaga>> mostrarQtdVagas(@PathVariable("qtdVagas") int qtd_vagas) {
        List<Vaga> vaga = ptSrv.mostrarQtdVagas(qtd_vagas);
        return ResponseEntity.ok(vaga);
    }

    // Mostrar quantidade de vaga ocupadas por setor
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

