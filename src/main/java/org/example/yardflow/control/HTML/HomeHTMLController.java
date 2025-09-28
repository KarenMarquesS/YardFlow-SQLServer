package org.example.yardflow.control.HTML;

import org.example.yardflow.repository.PatioRepositorio;
import org.example.yardflow.repository.Registro_check_in_outRepositorio;
import org.example.yardflow.repository.FuncaoRepositorio;
import org.example.yardflow.service.MotoCachingService;
import org.example.yardflow.service.YardflowCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class HomeHTMLController {

    @Autowired
    private PatioRepositorio patioRepo;

    @Autowired(required = false)
    private Registro_check_in_outRepositorio registroRepo;

    @Autowired
    private FuncaoRepositorio funcaoRepo;

    @Autowired
    private MotoCachingService mtS;

    @Autowired
    private YardflowCachingService yfS;

    @GetMapping({"/", "/index"})
    public String mostrarIndex() {
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView mostrarHome() {
        ModelAndView mv = new ModelAndView("home");

        long vagasTotal = patioRepo.findAll().stream().mapToLong(p -> p.getQtdvagas()).sum();

        long vagasOcupadas = 0;
        long motosMais5Dias = 0;
        if (registroRepo != null) {
            var todos = registroRepo.findByEntradapatioIsNotNull();

            vagasOcupadas = (long) todos.stream()
                    .filter(r -> r.getSaidapatio() == null)
                    .count();

            motosMais5Dias = (long) todos.stream()
                    .filter(r -> r.getSaidapatio() == null)
                    .filter(r -> r.getEntradapatio() != null)
                    .filter(r -> java.time.temporal.ChronoUnit.DAYS
                            .between(r.getEntradapatio(), LocalDate.now()) > 5)
                    .count();
        }
        long vagasLivres = Math.max(vagasTotal - vagasOcupadas, 0);

        mv.addObject("vagasTotal", vagasTotal);
        mv.addObject("vagasOcupadas", vagasOcupadas);
        mv.addObject("vagasLivres", vagasLivres);
        mv.addObject("motosMais5Dias", motosMais5Dias);
        mv.addObject("nome", "Pátio Principal");
        return mv;
    }

    // Rotas de visualização para navegar a partir da Home
    @GetMapping("/cadastros/moto")
    public ModelAndView viewCadastroMoto() {
        ModelAndView mv = new ModelAndView("cadastros/moto");
        mv.addObject("motoDTO", new org.example.yardflow.dto.MotoDTO());
        mv.addObject("modelos", org.example.yardflow.model.EnumModelo.values());
        return mv;
    }

    @GetMapping("/cadastros/patio")
    public ModelAndView viewCadastroPatio() {
        ModelAndView mv = new ModelAndView("cadastros/patio");
        mv.addObject("patioDTO", new org.example.yardflow.dto.PatioDTO());
        return mv;
    }

    @GetMapping("/cadastros/usuario")
    public ModelAndView viewCadastroUsuario() {
        ModelAndView mv = new ModelAndView("cadastros/usuario");
        mv.addObject("usuario", new org.example.yardflow.model.Usuario());
        mv.addObject("lista_funcoes", funcaoRepo.findAll());
        return mv;
    }

    @GetMapping("/cadastros/yardflow")
    public ModelAndView viewCadastroYardflow() {
        ModelAndView mv = new ModelAndView("cadastros/yardflow");
        mv.addObject("yardflows", java.util.Collections.emptyList());
        return mv;
    }

    @GetMapping("/consultas/listaMoto")
    public ModelAndView viewListaMoto(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        ModelAndView mv = new ModelAndView("consultas/listaMoto");

        // Monta lista simples com dados de exemplo vindos do banco via registros
        var registros = registroRepo != null ? registroRepo.findByEntradapatioIsNotNull() : java.util.List.<org.example.yardflow.model.Registro_check_in_out>of();
        var lista = new java.util.ArrayList<java.util.Map<String, Object>>();

        for (var r : registros) {
            var map = new java.util.HashMap<String, Object>();
            map.put("id_yf", r.getMoto() != null && r.getMoto().getYardflow() != null ? r.getMoto().getYardflow().getIdyf() : null);
            map.put("id_moto", r.getMoto() != null ? r.getMoto().getIdmoto() : null);
            map.put("placa", r.getMoto() != null ? r.getMoto().getPlaca() : null);
            map.put("dataEntrada", r.getEntradapatio());
            map.put("dataSaida", r.getSaidapatio());
            map.put("periodoEstadia", r.getPeriodo());
            lista.add(map);
        }

        // Implementar paginação manual
        int totalItems = lista.size();
        int totalPages = (int) Math.ceil((double) totalItems / size);
        int startIndex = page * size;
        int endIndex = Math.min(startIndex + size, totalItems);

        var paginatedList = lista.subList(startIndex, endIndex);

        mv.addObject("motos", paginatedList);
        mv.addObject("currentPage", page);
        mv.addObject("totalPages", totalPages);
        mv.addObject("size", size);

        return mv;
    }

    @GetMapping("/consultas/localizarMoto")
    public ModelAndView viewLocalizarMoto() {
        ModelAndView mv = new ModelAndView("consultas/localizarMoto");
        return mv;
    }

    @PostMapping("/consultas/buscarMoto")
    public ModelAndView buscarMoto(@RequestParam(value = "idyf", required = false) Integer idyf,
                                   @RequestParam(value = "placa", required = false) String placa,
                                   @RequestParam(value = "chassi", required = false) String chassi) {
        ModelAndView mv = new ModelAndView("consultas/resultadoBuscaMoto");

        try {
            org.example.yardflow.model.Moto moto = null;

            // Busca por ID YardFlow
            if (idyf != null && idyf > 0) {
                try {
                    moto = yfS.localizarMotoPorYardFlow(idyf);
                } catch (Exception e) {
                    // YardFlow não encontrado ou sem moto associada
                }
            }

            // Busca por placa
            if (moto == null && placa != null && !placa.trim().isEmpty()) {
                try {
                    org.example.yardflow.dto.MotoDTO motoDTO = mtS.findByPlaca(placa.trim());
                    if (motoDTO != null) {
                        // Converter DTO para entidade Moto
                        moto = mtS.findById(motoDTO.getIdmoto()).orElse(null);
                    }
                } catch (Exception e) {
                    // Placa não encontrada
                }
            }

            // Busca por chassi
            if (moto == null && chassi != null && !chassi.trim().isEmpty()) {
                try {
                    org.example.yardflow.dto.MotoDTO motoDTO = mtS.findByChassi(chassi.trim());
                    if (motoDTO != null) {
                        // Converter DTO para entidade Moto
                        moto = mtS.findById(motoDTO.getIdmoto()).orElse(null);
                    }
                } catch (Exception e) {
                    // Chassi não encontrado
                }
            }

            mv.addObject("moto", moto);

        } catch (Exception e) {
            mv.addObject("moto", null);
        }

        return mv;
    }
}


