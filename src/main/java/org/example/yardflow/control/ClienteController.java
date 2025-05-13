package org.example.yardflow.control;

import org.example.yardflow.DTO.ClienteDTO;
import org.example.yardflow.model.Cliente;
import org.example.yardflow.model.Moto;
import org.example.yardflow.repository.ClienteRepositorio;
import org.example.yardflow.service.ClienteCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepositorio repCl;

    @Autowired
    private ClienteCachingService srvCl;

    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable int idCliente) {
        Optional<Cliente> cliente = srvCl.findById(idCliente);
        return cliente.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable("idCliente") int idCliente, @RequestBody ClienteDTO clienteDTO) {
        return repCl.findById(idCliente).map(cliente -> {
            cliente.setMoto(clienteDTO.getMoto());
            cliente.setTelefone(clienteDTO.getTelefone());
            cliente.setPlano(clienteDTO.getPlano());

            Cliente clienteAtualizado = repCl.save(cliente);

            return ResponseEntity.ok(new ClienteDTO(clienteAtualizado));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/paginaCliente")
    public ResponseEntity<Page<ClienteDTO>> ClientesPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        PageRequest req = PageRequest.of(page, size);
        Page<ClienteDTO> ClientesPaginado = srvCl.listarClientesPaginado(req);
        return ResponseEntity.ok(ClientesPaginado);
    }

    @GetMapping("/{id}/cliente")
    public ResponseEntity<Moto> motoDoCliente(@PathVariable int idCliente) {
        return ResponseEntity.ok(srvCl.motoDoCliente(idCliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desativarCliente(@PathVariable int id) {
      Optional<Cliente> opCliente = srvCl.findById(id);
      if (opCliente.isPresent()) {
          Cliente cliente = opCliente.get();
          cliente.setAtivo(false);
          repCl.save(cliente);
          return ResponseEntity.noContent().build();
      }else{
          return ResponseEntity.notFound().build();
      }
    }
}
