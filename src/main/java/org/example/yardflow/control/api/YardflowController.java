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

    @PostMapping("/ativar/{idyf}")
    public ResponseEntity<Yardflow> ativarYardFlow(@RequestBody @Valid int idyf, @PathVariable int idmoto) {
        return ResponseEntity.ok(yfS.ativarYardFlow(idyf, idmoto));
    }

    @PostMapping("/desativar/{idyf}")
    public ResponseEntity<Yardflow> desativarYardFlow(@RequestBody @Valid int idyf) {
        return ResponseEntity.ok(yfS.desativarYardFlow(idyf));
    }

    @GetMapping("/{idyf}")
    public ResponseEntity<Moto> localizarMoto(@PathVariable int idyf) {
        return ResponseEntity.ok(yfS.localizarMotoPorYardFlow(idyf));
    }

    @GetMapping("{/serial}")
    public ResponseEntity<Optional<Yardflow>> localizarSerialYf(@PathVariable String serial) {
        return ResponseEntity.ok(yfS.buscarSerial(serial));
    }

    @GetMapping("{/dt_ultimo_acionamento}")
    public ResponseEntity<List<Yardflow>> buscarUltimoAcionamento(@RequestParam("data")
                                                                  @DateTimeFormat (iso = DateTimeFormat.ISO.DATE)
                                                             LocalDate dtultimoacionamento) {
        List<Yardflow> yf = yfS.buscarDtUltimoAcionamento(dtultimoacionamento);

        if(yf == null || yf .isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(yf);
    }

    @DeleteMapping("/{idyf}")
    public ResponseEntity<Void> removerYardFlow(@PathVariable int idyf) {
        yfS.removerYardFlow(idyf);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/limparcache")
    public ResponseEntity<Void> limparCache() {
        yfS.limparCache();
        return ResponseEntity.noContent().build();
    }

}

