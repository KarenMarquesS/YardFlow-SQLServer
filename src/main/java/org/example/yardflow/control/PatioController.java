package org.example.yardflow.control;

import org.example.yardflow.model.Patio;
import org.example.yardflow.model.SetorEnum;
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
                .orElseThrow(() -> new IllegalArgumentException(">> Setor Não Localisado: <<" + setor));
    }

    // Buscar pátio por ID da vaga
    @GetMapping("/vaga/{id_vaga}")
    public ResponseEntity<Patio> buscarPorIdVaga(@PathVariable("id_vaga") int id_vaga) {
        return ptSrv.buscarPorIdVagas(id_vaga)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new IllegalArgumentException(">> ID da Vaga inválido: <<" + id_vaga));
    }

    // Mostrar quantidade de vagas igual a um número específico
    @GetMapping("/quantidadevagas/{qtd_vagas}")
    public ResponseEntity<List<Patio>> mostrarQtdVagas(@PathVariable("qtd_vagas") int qtd_vagas) {
        List<Patio> patios = ptSrv.mostrarQtdVagas(qtd_vagas);

        return ResponseEntity.ok(patios);
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

