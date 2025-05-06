package org.example.yardflow.control;


import org.example.yardflow.repository.VagaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@RestController
//@RequestMapping("/vagas")
//public class VagaController {
//
//    @Autowired
//    private VagaRepositorio vagaRepositorio;
//
//    @GetMapping
//    public Page<Vaga> listarVagas(Pageable pageable) {
//        return vagaRepositorio.findAll(pageable);
//    }
//
//    @GetMapping("/por-setor")
//    public Page<Vaga> buscarPorSetor(@RequestParam SetorEnum setor, Pageable pageable) {
//        return vagaRepositorio.findBySetor(setor, pageable);
//    }
//}
//
//@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size,
//@RequestParam(defaultValue = "idVaga") String sortBy, @RequestParam(defaultValue = "asc") String direction