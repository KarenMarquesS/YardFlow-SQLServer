package org.example.yardflow.control.api;


import jakarta.validation.Valid;
import org.example.yardflow.dto.YardflowDTO;
import org.example.yardflow.model.Moto;
import org.example.yardflow.model.Yardflow;
import org.example.yardflow.service.YardflowCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


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
    public ResponseEntity<Yardflow> ativarYardFlow(@RequestBody @Valid int id_yf, @PathVariable int id_moto) {
        return ResponseEntity.ok(yfS.ativarYardFlow(id_yf, id_moto));
    }

    @PostMapping("/desativar/{id_yf}")
    public ResponseEntity<Yardflow> desativarYardFlow(@RequestBody @Valid int id_yf) {
        return ResponseEntity.ok(yfS.desativarYardFlow(id_yf));
    }

    @GetMapping("/{id_yf}")
    public ResponseEntity<Moto> localizarMoto(@PathVariable int id_yf) {
        return ResponseEntity.ok(yfS.localizarMotoPorYardFlow(id_yf));
    }

    @GetMapping("{/serial}")
    public ResponseEntity<Optional<Yardflow>> localizarSerialYf(@PathVariable String serial) {
        return ResponseEntity.ok(yfS.buscarSerial(serial));
    }

    @GetMapping("{/dt_ultimo_acionamento}")
    public ResponseEntity<List<Yardflow>> buscarUltimoAcionamento(@RequestParam("data")
                                                                  @DateTimeFormat (iso = DateTimeFormat.ISO.DATE)
                                                             LocalDate dt_ultimo_acionamento) {
        List<Yardflow> yf = yfS.buscarDtUltimoAcionamento(dt_ultimo_acionamento);

        if(yf == null || yf .isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(yf);
    }

    @DeleteMapping("/{id_yf}")
    public ResponseEntity<Void> removerYardFlow(@PathVariable int id_yf) {
        yfS.removerYardFlow(id_yf);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/limparcache")
    public ResponseEntity<Void> limparCache() {
        yfS.limparCache();
        return ResponseEntity.noContent().build();
    }

}

