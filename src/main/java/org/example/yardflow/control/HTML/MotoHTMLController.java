package org.example.yardflow.control.HTML;

import org.example.yardflow.dto.MotoDTO;
import org.example.yardflow.model.Moto;
import org.example.yardflow.service.MotoCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/moto")
public class MotoHTMLController {

    @Autowired
    private MotoCachingService mtS;

    @GetMapping("/{id_moto}")
    public ModelAndView buscarPorId(@PathVariable int id_moto) {
        ModelAndView mv = new ModelAndView("moto");
        Moto moto = mtS.findById(id_moto).orElseThrow(() -> new IllegalArgumentException("Moto não localizada"));
        mv.addObject("moto", moto);
        return mv;
    }

    @GetMapping("/{chassi}")
    public ModelAndView buscarPorChassi(@PathVariable String chassi) {
        ModelAndView mv = new ModelAndView("moto_chassi");
        MotoDTO motoDTO = mtS.findByChassi(chassi);
        mv.addObject("motoDTO", motoDTO);
        return mv;
    }

    @GetMapping("/{placa}")
    public ModelAndView buscarPorPlaca(@PathVariable String placa) {
        ModelAndView mv = new ModelAndView("moto_placa");
        MotoDTO motoDTO = mtS.findByPlaca(placa);
        mv.addObject("motoDTO", motoDTO);
        return mv;
    }

    @GetMapping("/{id_moto}")
    public ModelAndView buscarHistorico(@PathVariable int id_moto) {
        ModelAndView mv = new ModelAndView("moto_historico");
        MotoDTO motoDTO = mtS.buscarHistorico(id_moto);
        mv.addObject("motoDTO", motoDTO);
        return mv;
    }

    @GetMapping("/inserir")
    public ModelAndView NovaMoto() {
        ModelAndView mv = new ModelAndView("moto");
        mv.addObject("moto", new Moto());
        return mv;
    }

    @PostMapping("/inserir")
    public ModelAndView inserir(@ModelAttribute MotoDTO dto) {
        mtS.criarNovaMoto(dto);
        return new ModelAndView("redirect:/moto");
    }

    @PostMapping("/atualizar/{id_moto}")
    public ModelAndView atulizar(@PathVariable int id_moto, @ModelAttribute MotoDTO dto) {
        mtS.atualizarRegistroMoto(id_moto, dto);
        return new ModelAndView("redirect:/moto");
    }

    @PostMapping("/{id_moto}")
    public ModelAndView deletar(@PathVariable int id_moto) {
        mtS.deletarRegistroMoto(id_moto);
        return new ModelAndView("redirect:/moto");
    }


}