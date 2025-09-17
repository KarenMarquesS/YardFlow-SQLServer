package org.example.yardflow.control.HTML;

import org.springframework.stereotype.Controller;

@Controller
public class MotoHTMLController {

// @GetMapping("/registro-moto")
//    public String registroMoto(Model model) {
//        model.addAttribute("moto", new MotoDTO());
//        model.addAttribute("modelos", EnumModelo.values());
//        return "registro-moto";
//    }
//
//    @PostMapping("/registro-moto")
//    public String salvarRegistro(@ModelAttribute MotoDTO moto,
//                                 @RequestParam("foto") MultipartFile foto) {
//        // salvar registro + upload da foto
//        return "redirect:/home";
//    }
//
//
//    private final MotoService motoService;
//
//    public MotoController(MotoService motoService) {
//        this.motoService = motoService;
//    }
//
//    // 🔹 Exibir modal com detalhes da moto
//    @GetMapping("/{id}")
//    public ModelAndView detalhesMoto(@PathVariable int id) {
//        ModelAndView mv = new ModelAndView("moto/modal-detalhes");
//        Moto moto = motoService.findByIdMoto(id).orElse(null);
//        mv.addObject("moto", moto);
//        return mv;
//    }
//
//    // 🔹 Atualizar histórico (pode ser chamado infinitas vezes)
//    @PostMapping("/atualizar-historico/{id}")
//    public String atualizarHistorico(@PathVariable int id,
//                                     @RequestParam("historico") String historico) {
//        motoService.findByIdMoto(id).ifPresent(moto -> {
//            moto.setHistorico(historico);
//            motoService.salvarOuAtualizar(moto);
//        });
//        return "redirect:/home"; // volta para a home
//    }
//
//    // 🔹 Atualizar dados da moto (somente uma vez)
//    @PostMapping("/editar/{id}")
//    public String atualizarMoto(@PathVariable int id,
//                                @ModelAttribute Moto motoAtualizada,
//                                Model model) {
//        motoService.findByIdMoto(id).ifPresent(moto -> {
//            // regra: só pode atualizar uma vez (você pode controlar isso com um flag ou comparação de atributos)
//            if (!moto.isAtualizado()) {
//                moto.setModelo(motoAtualizada.getModelo());
//                moto.setChassi(motoAtualizada.getChassi());
//                moto.setPlaca(motoAtualizada.getPlaca());
//                moto.setYFlowIoT(motoAtualizada.getYFlowIoT());
//
//                moto.setAtualizado(true); // marca como já atualizado
//                motoService.salvarOuAtualizar(moto);
//            } else {
//                model.addAttribute("erro", "A moto só pode ser atualizada uma vez.");
//            }
//        });
//        return "redirect:/home";
//    }
//
//    // 🔹 Deletar moto
//    @PostMapping("/deletar/{id}")
//    public String deletarMoto(@PathVariable int id) {
//        motoService.deletarPorId(id);
//        return "redirect:/home";
//    }
//
//    // 🔹 Definir Data de Saída + desativar moto
//    @PostMapping("/desativar/{id}")
//    public String desativarMoto(@PathVariable int id,
//                                @RequestParam("dataSaida") String dataSaidaStr) {
//        motoService.findByIdMoto(id).ifPresent(moto -> {
//            LocalDate dataSaida = LocalDate.parse(dataSaidaStr);
//            moto.setDataSaida(dataSaida);
//            moto.setAtivo(false);
//            motoService.salvarOuAtualizar(moto);
//        });
//        return "redirect:/home";
//    }

}
