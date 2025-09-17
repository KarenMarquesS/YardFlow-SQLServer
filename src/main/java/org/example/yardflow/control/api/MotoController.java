package org.example.yardflow.control.api;

import jakarta.validation.Valid;
import org.example.yardflow.dto.MotoDTO;
import org.example.yardflow.model.Moto;
import io.swagger.v3.oas.annotations.Operation;
import org.example.yardflow.service.MotoCachingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/moto")
public class MotoController {

    @Autowired
    private MotoCachingService servMt;

    @Autowired
    private ModelMapper modelMapper;



    @GetMapping("/buscar{id_moto}")
    public ResponseEntity<Moto> buscarIdMoto(@PathVariable int id_moto){
        Moto moto = servMt.findById(id_moto);
        if(moto == null){
            return ResponseEntity.ok(moto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    // Buscar por placa
    @GetMapping("/placa/{placa}")
    public ResponseEntity<Moto> buscarPorPlaca(@PathVariable String placa) {
        Moto moto = servMt.findByPlaca(placa);
        if (moto != null) {
            return ResponseEntity.ok(moto);
        }
        return ResponseEntity.notFound().build();
    }

    // Buscar por chassi
    @GetMapping("/chassi/{chassi}")
    public ResponseEntity<Moto> buscarPorChassi(@PathVariable String chassi) {
        Moto moto = servMt.findByChassi(chassi);
        if (moto != null) {
            return ResponseEntity.ok(moto);
        }
        return ResponseEntity.notFound().build();
    }


//    @Operation(description = "Este endpoint irá realizar as inserções das informações refentes a Moto", tags="Inserir " +
//            "Dados", summary="Irá inserir os dados da Moto")
//    @PostMapping(value = "/inserir")
//    public ResponseEntity<?> inserirMoto(@RequestBody @Valid MotoDTO motoDTO, BindingResult result){
//        if(result.hasErrors()){
//            return ResponseEntity.badRequest().body(result.getAllErrors());
//        }
//        Moto moto = modelMapper.map(motoDTO, Moto.class);
//        return ResponseEntity.ok(servMt.salvarOuAtualizar(moto));
//    }

    // atualizar moto

//    @GetMapping(value = "/historico/{id_moto}")
//    public ResponseEntity<Page<MotoDTO>> historicoPaginado(
//            @PathVariable int id_moto,
//            @RequestParam(value = "page", defaultValue = "0") int page,
//            @RequestParam(value = "size", defaultValue = "2") int size){
//
//        return ResponseEntity.ok(servMt.getAllMotosPaginado(id_moto, page, size));
//    }

    // Buscar apenas o histórico da moto pelo id (com cache)
    @GetMapping("/buscar/historico/{id_moto}")
    public ResponseEntity<String> buscarHistoricoMoto(@PathVariable int id_moto) {
        String historico = servMt.mostrarHistoricoMoto(id_moto);
        if (historico != null) {
            return ResponseEntity.ok(historico);
        }
        return ResponseEntity.notFound().build();
    }


//    @PatchMapping("/historico/{id_moto}")
//    public ResponseEntity<Moto> atualizarHistoricoMoto(@PathVariable int id_moto, @RequestBody String historico){
//
//        Moto moto = servMt.findByIdMoto(id_moto);
//        if (moto == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        moto.setHistorico(historico);
//        Moto atualizado = servMt.salvarOuAtualizar(moto);
//        return ResponseEntity.ok(atualizado);
//    }
//
//
//    @DeleteMapping("/desativar/{id_moto}")
//    public ResponseEntity<Void> desativarMoto(@PathVariable int id_moto) {
//        servMt.desativarMoto(id_moto);
//        return ResponseEntity.noContent().build();
//    }


    @DeleteMapping("/cache/limpar")
    public ResponseEntity<Void> limparCache() {
        servMt.limparCache();
        return ResponseEntity.noContent().build();
    }

}
