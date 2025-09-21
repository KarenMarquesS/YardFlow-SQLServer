package org.example.yardflow.control.api;


import jakarta.validation.Valid;
import org.example.yardflow.dto.YardflowDTO;
import org.example.yardflow.model.Moto;
import org.example.yardflow.model.Yardflow;
import org.example.yardflow.service.YardflowCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping(value = "/YardFlow")
public class YardflowController {

    @Autowired
    private YardflowCachingService yfS;

    @PostMapping("/criar")
    public ResponseEntity<Yardflow> criarYardFlow(@RequestBody @Valid YardflowDTO yfDTO) {
        Yardflow yf = new Yardflow();
        yf.setSerial(yfDTO.getSerial());

        return ResponseEntity.ok(yf);
    }

    @PostMapping("/acionar")
    public ResponseEntity<Yardflow> acionarYardFlow(@RequestBody @Valid YardflowDTO yfDTO) {
        Yardflow yf = new Yardflow();
        yf.setSerial(yfDTO.getSerial());

        return ResponseEntity.ok(yf);
    }

    @PostMapping("/ativar/{id_yf}")
    public ResponseEntity<Yardflow> ativarYardFlow(@RequestBody @Valid UUID id_yf, @PathVariable int id_moto) {
        return ResponseEntity.ok(yfS.ativarYardFlow(id_yf, id_moto));
    }

    @PostMapping("/desativar/{id_yf}")
    public ResponseEntity<Yardflow> desativarYardFlow(@RequestBody @Valid UUID id_yf) {
        return ResponseEntity.ok(yfS.desativarYardFlow(id_yf));
    }

    @GetMapping("/{id_yf}")
    public ResponseEntity<Moto> localizarMoto(@PathVariable UUID id_yf) {
        return ResponseEntity.ok(yfS.localizarMotoPorYardFlow(id_yf));
    }

    @DeleteMapping("/{id_yf}")
    public ResponseEntity<Void> removerYardFlow(@PathVariable UUID id_yf) {
        yfS.removerYardFlow(id_yf);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/limparcache")
    public ResponseEntity<Void> limparCache() {
        yfS.limparCache();
        return ResponseEntity.noContent().build();
    }

}

