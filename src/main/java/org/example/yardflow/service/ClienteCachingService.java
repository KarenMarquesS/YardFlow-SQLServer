package org.example.yardflow.service;


import jakarta.persistence.EntityNotFoundException;
import org.example.yardflow.dto.ClienteDTO;
import org.example.yardflow.model.Cliente;
import org.example.yardflow.model.Moto;
import org.example.yardflow.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteCachingService {

    @Autowired
    private ClienteRepositorio clRep;

    @Cacheable(value = "buscarIdCliente", key = "#idCliente")
    public Optional<Cliente> findById(int idCliente){
        return clRep.findById(idCliente);
    }

    @Cacheable(value = "paginaCliente", key = "#req")
    public Page<ClienteDTO> listarClientesPaginado(PageRequest req) {
        return clRep.findAll(req).map(ClienteDTO::new);
    }

    @Cacheable(value = "MotoDoCliente", key = "#idCliente")
    public Moto motoDoCliente(int idCliente) {
        Cliente cl = clRep.findById(idCliente).orElseThrow(() -> new EntityNotFoundException(">> Cliente não " +
                "Localizado com o id informado: " +idCliente));
        return cl.getMoto();
    }

    @Cacheable(value="atualizaCacheCliente", key="#idCliente")
    public ClienteDTO atualizarCliente(ClienteDTO clienteDTO){
        Cliente cliente = clRep.findById(clienteDTO.getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setPlano(clienteDTO.getPlano());

        return new ClienteDTO(clRep.save(cliente));
    }

    @CacheEvict(value = {"buscarIdCliente", "paginaCliente", "MotoDoCliente", "atualizaCacheCliente"}, allEntries = true)
    public void limparCachingCliente() {
        System.out.println(">> Removido arquivos do cache de Clientes! <<");

    }

}
