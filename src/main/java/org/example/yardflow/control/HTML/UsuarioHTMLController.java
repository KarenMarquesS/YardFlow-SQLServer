package org.example.yardflow.control.HTML;

import org.example.yardflow.model.Funcao;
import org.example.yardflow.model.Usuario;
import org.example.yardflow.repository.FuncaoRepositorio;
import org.example.yardflow.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller("/usuario")
public class UsuarioHTMLController {


    @Autowired
    private UsuarioRepositorio usR;

    @Autowired
    private FuncaoRepositorio fuR;

    @Autowired
    private PasswordEncoder encoder;


    @GetMapping("/usuario/novo")
    public ModelAndView retornarCadUsuario() {
        ModelAndView mv = new ModelAndView("/usuario/novo");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<Usuario> op = usR.findBynome(auth.getName());

        op.ifPresent(usuario -> mv.addObject("usuario_logado", usuario));

        mv.addObject("usuario", new Usuario());
        mv.addObject("lista_funcoes", fuR.findAll());

        return mv;
    }

    @PostMapping("/insere_usuario")
    public ModelAndView inserirUsuario(Usuario usuario,
                                       @RequestParam(name = "idfuncao", required = false) Long idfuncao) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));

        Set<Funcao> funcoes = new HashSet<>();
        if (idfuncao != null) {
            fuR.findById(idfuncao).ifPresent(funcoes::add);
        }

        usuario.setFuncoes(funcoes);
        usR.save(usuario);

        return new ModelAndView("redirect:/index");
    }

    @GetMapping("/usuario/lista")
    public ModelAndView listarUsuarios() {
        ModelAndView mv = new ModelAndView("/usuario/lista");
        mv.addObject("usuarios", usR.findAll());
        return mv;
    }

    @GetMapping("/usuario/editar/{id}")
    public ModelAndView editarUsuario(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("/usuario/editar");
        Usuario usuario = usR.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        mv.addObject("usuario", usuario);
        mv.addObject("lista_funcoes", fuR.findAll());
        return mv;
    }

    @PostMapping("/usuario/atualizar")
    public ModelAndView atualizarUsuario(Usuario usuario, @RequestParam(name = "id_funcao", required = false) Long id_funcao) {
        if (usuario.getSenha() != null && !usuario.getSenha().isBlank()) {
            usuario.setSenha(encoder.encode(usuario.getSenha()));
        }

        Set<Funcao> funcoes = new HashSet<>();
        if (id_funcao != null) {
            fuR.findById(id_funcao).ifPresent(funcoes::add);
        }

        usuario.setFuncoes(funcoes);
        usR.save(usuario);

        return new ModelAndView("redirect:/usuario/lista");
    }

    @GetMapping("/usuario/deletar/{id}")
    public ModelAndView deletarUsuario(@PathVariable Long id) {
        usR.deleteById(id);
        return new ModelAndView("redirect:/usuario/lista");
    }

}
