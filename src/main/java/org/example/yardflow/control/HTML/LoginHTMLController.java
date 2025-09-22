package org.example.yardflow.control.HTML;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/login")
public class LoginHTMLController {

    @GetMapping("/logar")
    public ModelAndView logar() {
        return new ModelAndView("/login");
    }

    @GetMapping("/acesso_negado")
    public ModelAndView retornarAcessoNegado() {
        return new ModelAndView("acesso_negado");
    }

}
