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
import java.util.Optional;



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
        try {
            // Usar o método que carrega as relações com moto
            List<Yardflow> yardflows = yardflowRepo.findAllWithMoto();
            
            // Se não há dados, informar que os dados do V3__insert devem ser carregados
            if (yardflows.isEmpty()) {
                mv.addObject("info", "Nenhum YardFlow encontrado. Certifique-se de que os dados do arquivo V3__insert_tabela.sql foram carregados no banco de dados.");
            }
            
            mv.addObject("yardflows", yardflows);
            mv.addObject("totalYardflows", yardflows.size());
        } catch (Exception e) {
            mv.addObject("yardflows", java.util.Collections.emptyList());
            mv.addObject("erro", "Erro ao carregar lista de YardFlows: " + e.getMessage());
        }
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
                                @RequestParam(value = "motoId", required = false) Long motoId) {
        try {
            // Limpar a moto do objeto yardflow para evitar problemas de estado
            yardflow.setMoto(null);
            
            if (motoId != null && motoId != 0) {
                Moto moto = motoRepo.findById(motoId)
                        .orElseThrow(() -> new IllegalArgumentException("Moto não encontrada"));
                yardflow.setMoto(moto);
            }
            
            yfS.criarNovoYardFlow(yardflow);
            return new ModelAndView("redirect:/yardflow/lista");
        } catch (Exception e) {
            ModelAndView mv = new ModelAndView("cadastros/novoYardflow");
            mv.addObject("yardflow", yardflow);
            mv.addObject("motos", motoRepo.findAll());
            mv.addObject("erro", "Erro ao inserir YardFlow: " + e.getMessage());
            return mv;
        }
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable long id) {
        ModelAndView mv = new ModelAndView("cadastros/editarYardflow");
        Yardflow yardflow = yardflowRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("YardFlow não encontrado"));
        mv.addObject("yardflow", yardflow);
        mv.addObject("motos", motoRepo.findAll());
        return mv;
    }

    @PostMapping("/atualizar/{id}")
    public ModelAndView atualizar(@PathVariable long id, @ModelAttribute Yardflow yardflow,
                                  @RequestParam(value = "motoId", required = false) Long motoId) {
        try {
            Yardflow yardflowExistente = yardflowRepo.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("YardFlow não encontrado"));
            
            // Validar serial obrigatório
            if (yardflow.getSerial() == null || yardflow.getSerial().trim().isEmpty()) {
                throw new IllegalArgumentException("Serial é obrigatório");
            }
            
            // Verificar se o serial já existe em outro YardFlow
            Optional<Yardflow> existingYf = yardflowRepo.findBySerial(yardflow.getSerial());
            if (existingYf.isPresent() && existingYf.get().getIdyf() != id) {
                throw new IllegalArgumentException("Já existe um YardFlow com o serial: " + yardflow.getSerial());
            }
            
            yardflowExistente.setSerial(yardflow.getSerial());
            yardflowExistente.setDtUltimoAcionamento(yardflow.getDtUltimoAcionamento());
            
            // Desassociar moto atual se necessário
            if (yardflowExistente.getMoto() != null) {
                Moto motoAtual = yardflowExistente.getMoto();
                motoAtual.setYardflow(null);
                yardflowExistente.setMoto(null);
                motoRepo.save(motoAtual);
            }
            
            // Associar nova moto se selecionada
            if (motoId != null && motoId != 0) {
                Moto moto = motoRepo.findById(motoId)
                        .orElseThrow(() -> new IllegalArgumentException("Moto não encontrada"));
                
                if (moto.getYardflow() != null) {
                    throw new IllegalArgumentException("A moto " + moto.getPlaca() + " já possui um YardFlow associado");
                }
                
                moto.setYardflow(yardflowExistente);
                yardflowExistente.setMoto(moto);
                motoRepo.save(moto);
            }
            
            yardflowRepo.save(yardflowExistente);
            return new ModelAndView("redirect:/yardflow/lista");
        } catch (Exception e) {
            ModelAndView mv = new ModelAndView("cadastros/editarYardflow");
            mv.addObject("yardflow", yardflow);
            mv.addObject("motos", motoRepo.findAll());
            mv.addObject("erro", "Erro ao atualizar YardFlow: " + e.getMessage());
            return mv;
        }
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletar(@PathVariable long id) {
        yfS.removerYardFlow(id);
        return new ModelAndView("redirect:/yardflow/lista");
    }


    @PostMapping("/{idyf}/ativar/{idmoto}")
    public ModelAndView ativar(@PathVariable long idyf, @PathVariable long idmoto) {
        Yardflow ativo = yfS.ativarYardFlow(idyf, idmoto);
        ModelAndView mv = new ModelAndView("yardflow_detalhe");
        mv.addObject("yardflow", ativo);
        return mv;
    }


    @PostMapping("/{idyf}/desativar")
    public ModelAndView desativar(@PathVariable long idyf) {
        Yardflow desativado = yfS.desativarYardFlow(idyf);
        ModelAndView mv = new ModelAndView("yardflow_detalhe");
        mv.addObject("yardflow", desativado);
        return mv;
    }


    @GetMapping("/{idyf}/moto")
    public ModelAndView localizarMoto(@PathVariable long idyf) {
        Moto moto = yfS.localizarMotoPorYardFlow(idyf);
        ModelAndView mv = new ModelAndView("moto_detalhe");
        mv.addObject("moto", moto);
        return mv;
    }


    @PostMapping("/{idyf}/remover")
    public ModelAndView remover(@PathVariable long idyf) {
        yfS.removerYardFlow(idyf);
        return new ModelAndView("redirect:/yardflow/lista");
    }

    @GetMapping("/popular-dados-teste")
    public ModelAndView popularDadosTeste() {
        try {
            // Verificar se já existem dados
            List<Yardflow> existingYardflows = yardflowRepo.findAll();
            if (!existingYardflows.isEmpty()) {
                return new ModelAndView("redirect:/yardflow/lista");
            }

            // Criar dados de teste baseados no V3__insert
            String[] serials = {"SN-ABC10001", "SN-ABC10002", "SN-ABC10003", "SN-ABC10004", "SN-ABC10005", "SN-ABC10006", "SN-ABC10007", "SN-ABC10008"};
            String[] datas = {"2025-01-10", "2025-02-20", "2025-03-05", "2025-04-18", "2025-05-25", "2025-05-25", "2025-05-25", "2025-05-25"};

            for (int i = 0; i < serials.length; i++) {
                Yardflow yf = new Yardflow();
                yf.setSerial(serials[i]);
                yf.setDtUltimoAcionamento(java.time.LocalDateTime.parse(datas[i] + "T10:00:00"));
                yardflowRepo.save(yf);
            }

            return new ModelAndView("redirect:/yardflow/lista");
        } catch (Exception e) {
            ModelAndView mv = new ModelAndView("consultas/listaYardflow");
            mv.addObject("erro", "Erro ao popular dados de teste: " + e.getMessage());
            mv.addObject("yardflows", java.util.Collections.emptyList());
            return mv;
        }
    }
}
