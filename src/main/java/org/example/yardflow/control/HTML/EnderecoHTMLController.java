package org.example.yardflow.control.HTML;

import org.example.yardflow.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/cep")
public class EnderecoHTMLController {

    @Autowired
    private EnderecoService edS;

    /**
     * Busca CEP usando API ViaCEP e retorna dados para preencher endereço
     */
    @GetMapping("/buscarEndereco")
    @ResponseBody
    public Endereco buscarEnderecoPorCep(@RequestParam("cep") String cep) {
        return enderecoService.retornarDadosViaCEP(cep);
    }

}
