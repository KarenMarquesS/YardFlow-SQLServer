package org.example.yardflow.service;


import jakarta.persistence.EntityNotFoundException;
import org.example.yardflow.DTO.ClienteDTO;
import org.example.yardflow.model.Cliente;
import org.example.yardflow.model.Moto;
import org.example.yardflow.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClienteCachingService {

    @Autowired
    private ClienteRepositorio clRep;


    public Page<ClienteDTO> listarClientesPaginado(Pageable pageable) {
        return clRep.findAll(pageable).map(ClienteDTO::new);
    }

    @Cacheable(value = "Motos por Cliente", key = "#idCliente")
    public List<Moto> motosPorCliente(int idCliente) {
        Cliente cl = clRep.findById(idCliente).orElseThrow(() -> new EntityNotFoundException(">> Cliente não " +
                "Localizado com o id informado: " +idCliente));
        return cl.getMoto();
    }

    @Cacheable(value = "CacheCliente", key="#idCliente")
    public ClienteDTO buscarCliente(int idCliente){
        Cliente cl = clRep.findById(idCliente).orElseThrow(() -> new EntityNotFoundException(">> Cliente não " +
                "Localizado com o id informado:  " +idCliente));
        return new ClienteDTO(cl);

    }

    @CachePut(value="atualizaCacheCliente", key="#idCliente")
    public ClienteDTO atualizarCliente(ClienteDTO clienteDTO){
        Cliente cl = clRep.findById(clienteDTO.getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException(">> Cliente não encontrado <<"));

                cl.setIdCliente(clienteDTO.getIdCliente());
                cl.setNome(clienteDTO.getNome());
                cl.setCpf(clienteDTO.getCpf());
                cl.getPlano();

                clRep.save(cl);
                return new ClienteDTO(cl);
    }

    @CacheEvict(value = "limpaCacheCliente", key = "#idCliente")
    public void deletarCliente(int idCliente) {
        clRep.deleteById(idCliente);
    }

}
