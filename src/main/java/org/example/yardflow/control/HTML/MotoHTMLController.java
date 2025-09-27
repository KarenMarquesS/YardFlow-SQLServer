package org.example.yardflow.control.HTML;

import org.example.yardflow.dto.MotoDTO;
import org.example.yardflow.model.EnumModelo;
import org.example.yardflow.model.Moto;
import org.example.yardflow.service.MotoCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@org.springframework.web.bind.annotation.RequestMapping("/moto")
public class MotoHTMLController {

    @Autowired
    private MotoCachingService mtS;

    @GetMapping("/id/{idmoto}")
    public ModelAndView buscarPorId(@PathVariable int idmoto) {
        ModelAndView mv = new ModelAndView("consultas/detalhesMoto");
        Moto moto = mtS.findById(idmoto).orElseThrow(() -> new IllegalArgumentException("Moto não localizada"));
        mv.addObject("moto", moto);
        return mv;
    }

    @GetMapping("/chassi/{chassi}")
    public ModelAndView buscarPorChassi(@PathVariable String chassi) {
        ModelAndView mv = new ModelAndView("consultas/detalhesMoto");
        MotoDTO motoDTO = mtS.findByChassi(chassi);
        mv.addObject("motoDTO", motoDTO);
        return mv;
    }

    @GetMapping("/placa/{placa}")
    public ModelAndView buscarPorPlaca(@PathVariable String placa) {
        ModelAndView mv = new ModelAndView("consultas/detalhesMoto");
        MotoDTO motoDTO = mtS.findByPlaca(placa);
        mv.addObject("motoDTO", motoDTO);
        return mv;
    }

    @GetMapping("/historico/{idmoto}")
    public ModelAndView buscarHistorico(@PathVariable int idmoto) {
        ModelAndView mv = new ModelAndView("consultas/detalhesMoto");
        MotoDTO motoDTO = mtS.buscarHistorico(idmoto);
        mv.addObject("motoDTO", motoDTO);
        return mv;
    }

    @GetMapping("/inserir/moto")
    public ModelAndView NovaMoto() {
        ModelAndView mv = new ModelAndView("cadastros/moto");
        mv.addObject("motoDTO", new MotoDTO());
        mv.addObject("modelos", EnumModelo.values());
        return mv;
    }

    @PostMapping("/inserir")
    public ModelAndView inserir(@ModelAttribute MotoDTO dto) {
        mtS.criarNovaMoto(dto);
        return new ModelAndView("redirect:/consultas/listaMoto");
    }

    @PostMapping("/atualizar/{idmoto}")
    public ModelAndView atulizar(@PathVariable int idmoto, @ModelAttribute MotoDTO dto) {
        mtS.atualizarRegistroMoto(idmoto, dto);
        return new ModelAndView("redirect:/consultas/listaMoto");
    }

    @GetMapping("/editar/{idmoto}")
    public ModelAndView editar(@PathVariable int idmoto) {
        ModelAndView mv = new ModelAndView("cadastros/editarMoto");
        MotoDTO motoDTO = mtS.findById(idmoto)
                .map(moto -> {
                    MotoDTO dto = new MotoDTO();
                    dto.setIdmoto(moto.getIdmoto());
                    dto.setModelo(moto.getModelo());
                    dto.setChassi(moto.getChassi());
                    dto.setPlaca(moto.getPlaca());
                    dto.setHistorico(moto.getHistorico());
                    dto.setYardflow(moto.getYardflow());
                    // Campos entrada, saida, yFlowIoT e ativo não existem na entidade Moto
                    // Serão null por padrão no DTO
                    return dto;
                })
                .orElseThrow(() -> new IllegalArgumentException("Moto não encontrada"));
        
        mv.addObject("motoDTO", motoDTO);
        mv.addObject("modelos", EnumModelo.values());
        return mv;
    }

    @PostMapping("/deletar/{idmoto}")
    public ModelAndView deletar(@PathVariable int idmoto) {
        mtS.deletarRegistroMoto(idmoto);
        return new ModelAndView("redirect:/consultas/listaMoto");
    }

}