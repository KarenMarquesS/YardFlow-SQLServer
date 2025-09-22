package org.example.yardflow.control.HTML;

import org.example.yardflow.model.Moto;
import org.example.yardflow.model.Yardflow;
import org.example.yardflow.service.YardflowCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller("/yf")
public class YardflowHTMLController {

    @Autowired
    private YardflowCachingService yfS;


    @PostMapping("/novo")
    public ModelAndView criar(@ModelAttribute Yardflow yardflow) {
        yfS.criarNovoYardFlow(yardflow);
        return new ModelAndView("redirect:/yardflow/lista");
    }


    @PostMapping("/{id_yf}/ativar/{id_moto}")
    public ModelAndView ativar(@PathVariable int id_yf, @PathVariable int id_moto) {
        Yardflow ativo = yfS.ativarYardFlow(id_yf, id_moto);
        ModelAndView mv = new ModelAndView("yardflow_detalhe");
        mv.addObject("yardflow", ativo);
        return mv;
    }


    @PostMapping("/{id_yf}/desativar")
    public ModelAndView desativar(@PathVariable int id_yf) {
        Yardflow desativado = yfS.desativarYardFlow(id_yf);
        ModelAndView mv = new ModelAndView("yardflow_detalhe");
        mv.addObject("yardflow", desativado);
        return mv;
    }


    @GetMapping("/{id_yf}/moto")
    public ModelAndView localizarMoto(@PathVariable int id_yf) {
        Moto moto = yfS.localizarMotoPorYardFlow(id_yf);
        ModelAndView mv = new ModelAndView("moto_detalhe");
        mv.addObject("moto", moto);
        return mv;
    }


    @PostMapping("/{id_yf}/remover")
    public ModelAndView remover(@PathVariable int id_yf) {
        yfS.removerYardFlow(id_yf);
        return new ModelAndView("redirect:/yardflow/lista");
    }
}
