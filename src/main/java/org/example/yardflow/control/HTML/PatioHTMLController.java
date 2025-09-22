package org.example.yardflow.control.HTML;



import org.example.yardflow.dto.PatioDTO;

import org.example.yardflow.model.Patio;
import org.example.yardflow.service.PatioCachingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller("/patio")
public class PatioHTMLController {

    @Autowired
    private PatioCachingService ptS;




    @GetMapping("/{id_patio}")
    public ModelAndView buscarPorId(@PathVariable int id_patio) {
        ModelAndView mv = new ModelAndView("patio_detalhe");
        Patio patio = ptS.buscarPatioPorId(id_patio)
                .orElseThrow(() -> new IllegalArgumentException("Pátio não encontrado"));
        mv.addObject("patio", patio);
        return mv;
    }


    @GetMapping("/qtd/{qtd_vagas}")
    public ModelAndView buscarPorQtdVagas(@PathVariable int qtd_vagas) {
        List<Patio> patios = ptS.buscarQtdVagas(qtd_vagas);
        ModelAndView mv = new ModelAndView("patio_lista");
        mv.addObject("patios", patios);
        return mv;
    }


    @GetMapping("/nome/{name}")
    public ModelAndView buscarPorNome(@PathVariable String name) {
        List<Patio> patios = ptS.buscarPatioPorNome(name);
        ModelAndView mv = new ModelAndView("patio_lista");
        mv.addObject("patios", patios);
        return mv;
    }


    @GetMapping("/novo")
    public ModelAndView novoPatio() {
        ModelAndView mv = new ModelAndView("patio_form");
        mv.addObject("patioDTO", new PatioDTO());
        return mv;
    }


    @PostMapping("/inserir")
    public ModelAndView inserir(@ModelAttribute PatioDTO dto) {
        ptS.inserirPatio(dto);
        return new ModelAndView("redirect:/patio/lista");
    }


    @PostMapping("/atualizar/{id_patio}")
    public ModelAndView atualizar(@PathVariable int id_patio, @ModelAttribute PatioDTO dto) {
        ptS.atualizarPatio(id_patio, dto);
        return new ModelAndView("redirect:/patio/" + id_patio);
    }


    @PostMapping("/deletar/{id_patio}")
    public ModelAndView deletar(@PathVariable int id_patio) {
        ptS.deletarPatio(id_patio);
        return new ModelAndView("redirect:/patio/lista");
    }

}
