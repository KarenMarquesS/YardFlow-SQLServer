package org.example.yardflow.control.HTML;

import org.example.yardflow.model.Moto;
import org.example.yardflow.model.Yardflow;
import org.example.yardflow.repository.MotoRepositorio;
import org.example.yardflow.repository.YardflowRepositorio;
import org.example.yardflow.service.YardflowCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@Controller
@RequestMapping("/yardflow")
public class YardflowHTMLController {

    @Autowired
    private YardflowCachingService yfS;

    @Autowired
    private YardflowRepositorio yardflowRepo;

    @Autowired
    private MotoRepositorio motoRepo;


    @GetMapping("/lista")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("consultas/listaYardflow");
        List<Yardflow> yardflows = yardflowRepo.findAll();
        mv.addObject("yardflows", yardflows);
        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("cadastros/novoYardflow");
        mv.addObject("yardflow", new Yardflow());
        mv.addObject("motos", motoRepo.findAll());
        return mv;
    }

    @PostMapping("/inserir")
    public ModelAndView inserir(@ModelAttribute Yardflow yardflow, 
                                @RequestParam(value = "motoId", required = false) Integer motoId) {
        if (motoId != null && motoId != 0) {
            Moto moto = motoRepo.findById(motoId)
                    .orElseThrow(() -> new IllegalArgumentException("Moto não encontrada"));
            yardflow.setMoto(moto);
        }
        yfS.criarNovoYardFlow(yardflow);
        return new ModelAndView("redirect:/yardflow/lista");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("cadastros/editarYardflow");
        Yardflow yardflow = yardflowRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("YardFlow não encontrado"));
        mv.addObject("yardflow", yardflow);
        mv.addObject("motos", motoRepo.findAll());
        return mv;
    }

    @PostMapping("/atualizar/{id}")
    public ModelAndView atualizar(@PathVariable int id, @ModelAttribute Yardflow yardflow,
                                  @RequestParam(value = "motoId", required = false) Integer motoId) {
        Yardflow yardflowExistente = yardflowRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("YardFlow não encontrado"));
        
        yardflowExistente.setSerial(yardflow.getSerial());
        yardflowExistente.setDtultimoacionamento(yardflow.getDtultimoacionamento());
        
        if (motoId != null && motoId != 0) {
            Moto moto = motoRepo.findById(motoId)
                    .orElseThrow(() -> new IllegalArgumentException("Moto não encontrada"));
            yardflowExistente.setMoto(moto);
        } else {
            yardflowExistente.setMoto(null);
        }
        
        yardflowRepo.save(yardflowExistente);
        return new ModelAndView("redirect:/yardflow/lista");
    }

    @PostMapping("/deletar/{id}")
    public ModelAndView deletar(@PathVariable int id) {
        yfS.removerYardFlow(id);
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
