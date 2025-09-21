package org.example.yardflow;

import org.example.yardflow.model.Endereco;
//import org.example.yardflow.service.EnderecoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
//public class TestEndereco {
//
//    @Autowired
//    //private EnderecoService enderecoService;
//
//
//    @Test
//    //void testBuscarEnderecoPorCepConsole() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Digite o CEP (com ou sem hífen): ");
//        String cep = scanner.nextLine();
//
//        System.out.print("Digite o número: ");
//        String numero = scanner.nextLine();
//
//        System.out.print("Digite o complemento (opcional): ");
//        String complemento = scanner.nextLine();
//
//        // Chama o service
//        Endereco endereco = enderecoService.retornarDadosViaCEP(cep);
//
//        // Validações
//        assertNotNull(endereco, "O endereço retornado não pode ser nulo");
//        assertEquals(cep.replace("-", ""), endereco.getCep().replace("-", ""), "O CEP retornado não confere");
//
//        // Adiciona dados manuais digitados
//        endereco.setNumero(numero);
//        if (!complemento.isEmpty()) {
//            endereco.setLogradouro(endereco.getLogradouro() + " - " + complemento);
//        }
//
//        // Exibe resultado no console
//        System.out.println("\n--- Endereço Encontrado ---");
//        System.out.println("CEP: " + endereco.getCep());
//        System.out.println("Logradouro: " + endereco.getLogradouro());
//        System.out.println("Número: " + endereco.getNumero());
//        System.out.println("Bairro: " + endereco.getBairro());
//        System.out.println("Cidade: " + endereco.getLocalidade());
//        System.out.println("UF: " + endereco.getUf());
//    }
}
