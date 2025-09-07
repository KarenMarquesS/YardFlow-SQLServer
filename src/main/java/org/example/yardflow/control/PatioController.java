package org.example.yardflow.control;

import org.example.yardflow.model.Patio;
import org.example.yardflow.model.EnumSetor;
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
    public ResponseEntity<List<Patio>> buscarPorSetor(@PathVariable("setor") EnumSetor setor) {
        List<Patio> patios = ptSrv.buscarPorSetor(setor);;

        if(patios.isEmpty()) {
            throw new IllegalArgumentException(">> Setor Não Localisado: <<" + setor);
        }
        return  ResponseEntity.ok(patios);
    }

    // Buscar pátio por ID da vaga
    @GetMapping("/vaga/{id_vaga}")
    public ResponseEntity<Patio> buscarPorIdVaga(@PathVariable("id_vaga") int id_vaga) {
        return ptSrv.buscarPorIdVagas(id_vaga)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new IllegalArgumentException(">> ID da Vaga inválido: <<" + id_vaga));
    }

    // Mostrar quantidade de vagas
    @GetMapping("/quantidadevagas/{qtd_vagas}")
    public ResponseEntity<List<Patio>> mostrarQtdVagas(@PathVariable("qtd_vagas") int qtd_vagas) {
        List<Patio> patios = ptSrv.mostrarQtdVagas(qtd_vagas);

        return ResponseEntity.ok(patios);
    }

    // Quantidade de vaga ocupadas por setor
    @GetMapping("/ocupada")
    public ResponseEntity<List<Object[]>> contarVagasOcupadasPorSetor() {
        return ResponseEntity.ok(ptSrv.mostrarVagaOcupadaPorSetor());
    }

    // Deletar pátio
    @DeleteMapping("/{id_patio}")
    public ResponseEntity<Void> deletarPatio(@PathVariable int id_patio) {
        ptSrv.deletarPatio(id_patio);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/limparcache")
    public ResponseEntity<Void> limparCache() {
        ptSrv.limparCache();
        return ResponseEntity.noContent().build();
    }
}

