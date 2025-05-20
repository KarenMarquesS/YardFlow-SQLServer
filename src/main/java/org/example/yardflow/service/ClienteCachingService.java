package org.example.yardflow.service;


import jakarta.persistence.EntityNotFoundException;
import org.example.yardflow.dto.ClienteDTO;
import org.example.yardflow.model.Cliente;
import org.example.yardflow.model.Moto;
import org.example.yardflow.repository.ClienteRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteCachingService {

    @Autowired
    private ClienteRepositorio clRep;

    @Autowired
    private ModelMapper mM;

    @Cacheable(value = "InserindoCliente")
    public ClienteDTO inserirCliente(ClienteDTO dto) {
        Cliente cliente = mM.map(dto, Cliente.class);
        Cliente salvo = clRep.save(cliente);

        return mM.map(salvo, ClienteDTO.class);
    }

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
      return clRep.buscarMotoPorIdCliente(id_cliente);
    }

    @CachePut(value="atualizaCacheCliente", key="#id_cliente")
    public ClienteDTO atualizarCliente(ClienteDTO dto){
        Cliente cliente = clRep.findById(dto.getId_cliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        mM.map(dto, cliente);
        return mM.map(clRep.save(cliente), ClienteDTO.class);
    }

    public boolean desativarCliente(int id_cliente) {
        Optional<Cliente> cliente = clRep.findById(id_cliente);
        if (cliente.isPresent()) {
            Cliente c = cliente.get();
            c.setAtivo(false);
            clRep.save(c);
            return true;
        }
        return false;
    }

    @CacheEvict(value = {"InserindoCliente, buscarIdCliente", "paginaCliente", "MotoDoCliente", "atualizaCacheCliente"}, allEntries = true)
    public void limparCachingCliente() {
        System.out.println(">> Removido arquivos do cache de Clientes! <<");

    }

}
