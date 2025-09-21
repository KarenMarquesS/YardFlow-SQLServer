package org.example.yardflow.control.HTML;

import jakarta.validation.Valid;
import org.example.yardflow.model.EnumFuncao;
import org.example.yardflow.model.Usuario;
import org.example.yardflow.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class UsuarioHTMLController {

    @Autowired
    public UsuarioRepositorio uR;



    @GetMapping("/index")
    public ModelAndView popularIndex() {

        ModelAndView mv = new ModelAndView("/home/index");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Optional<Usuario> op = uR.findByUsername(auth.getName());

        if(op.isPresent()) {
            mv.addObject("usuario", op.get());
        }


        return mv;
    }


    @PostMapping("insere_pessoa")
    public ModelAndView inserirPessoa(@Valid Usuario usuario, BindingResult bd) {

        if(bd.hasErrors()) {

            ModelAndView mv = new ModelAndView("/usuario/novo");
            mv.addObject("usuario", usuario);
            mv.addObject("funcao", EnumFuncao.values());
            return mv;

        } else {

            Usuario novo = new Usuario();
            novo.setNome(usuario.getNome());
            novo.setEmail(usuario.getEmail());
            novo.setSenha(usuario.getSenha());

            uR.save(novo);


            return new ModelAndView("redirect:/index");
        }
    }





}
