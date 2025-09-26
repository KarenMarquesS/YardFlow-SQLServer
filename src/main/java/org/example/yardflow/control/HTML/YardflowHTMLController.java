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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/yf")
public class YardflowHTMLController {

    @Autowired
    private YardflowCachingService yfS;


    @PostMapping("/novo")
    public ModelAndView criar(@ModelAttribute Yardflow yardflow) {
        yfS.criarNovoYardFlow(yardflow);
        return new ModelAndView("redirect:/yardflow/lista");
    }


    @PostMapping("/{idyf}/ativar/{idmoto}")
    public ModelAndView ativar(@PathVariable int idyf, @PathVariable int idmoto) {
        Yardflow ativo = yfS.ativarYardFlow(idyf, idmoto);
        ModelAndView mv = new ModelAndView("yardflow_detalhe");
        mv.addObject("yardflow", ativo);
        return mv;
    }


    @PostMapping("/{idyf}/desativar")
    public ModelAndView desativar(@PathVariable int idyf) {
        Yardflow desativado = yfS.desativarYardFlow(idyf);
        ModelAndView mv = new ModelAndView("yardflow_detalhe");
        mv.addObject("yardflow", desativado);
        return mv;
    }


    @GetMapping("/{idyf}/moto")
    public ModelAndView localizarMoto(@PathVariable int idyf) {
        Moto moto = yfS.localizarMotoPorYardFlow(idyf);
        ModelAndView mv = new ModelAndView("moto_detalhe");
        mv.addObject("moto", moto);
        return mv;
    }


    @PostMapping("/{idyf}/remover")
    public ModelAndView remover(@PathVariable int idyf) {
        yfS.removerYardFlow(idyf);
        return new ModelAndView("redirect:/yardflow/lista");
    }
}
