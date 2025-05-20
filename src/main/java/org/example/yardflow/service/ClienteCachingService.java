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

    @Cacheable(value = "buscarIdCliente", key = "#id_cliente")
    public Optional<Cliente> findById(int id_cliente){
        return clRep.findById(id_cliente);
    }

    @Cacheable(value = "paginaCliente", key = "#req")
    public Page<ClienteDTO> listarClientesPaginado(PageRequest req) {
        return clRep.findAll(req).map(ClienteDTO::new);
    }

    @Cacheable(value = "MotoDoCliente", key = "#id_cliente")
    public Moto motoDoCliente(int id_cliente) {
        Cliente cl = clRep.findById(id_cliente).orElseThrow(() -> new EntityNotFoundException(">> Cliente não " +
                "Localizado com o id informado: " +id_cliente));
        return cl.getMoto();
    }

    @Cacheable(value="atualizaCacheCliente", key="#id_cliente")
    public ClienteDTO atualizarCliente(ClienteDTO clienteDTO){
        Cliente cliente = clRep.findById(clienteDTO.getId_cliente())
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
