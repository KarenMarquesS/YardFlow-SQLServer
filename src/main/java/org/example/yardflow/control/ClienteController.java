package org.example.yardflow.control;

import org.example.yardflow.dto.ClienteDTO;
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

    @GetMapping("/buscar/{id_cliente}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable int id_cliente) {
        Optional<Cliente> cliente = srvCl.findById(id_cliente);
        return cliente.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar/{id_cliente}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable("id_cliente") int id_cliente, @RequestBody ClienteDTO clienteDTO) {
        return repCl.findById(id_cliente).map(cliente -> {
            cliente.setMoto(clienteDTO.getMoto());
            cliente.setTelefone(clienteDTO.getTelefone());
            cliente.setPlano(clienteDTO.getPlano());

            Cliente clienteAtualizado = repCl.save(cliente);

            return ResponseEntity.ok(new ClienteDTO(clienteAtualizado));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/paginas")
    public ResponseEntity<Page<ClienteDTO>> ClientesPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        PageRequest req = PageRequest.of(page, size);
        Page<ClienteDTO> ClientesPaginado = srvCl.listarClientesPaginado(req);
        return ResponseEntity.ok(ClientesPaginado);
    }

    @GetMapping("/motoCliente/{id_cliente}")
    public ResponseEntity<Moto> motoDoCliente(@PathVariable int id_cliente) {
        return ResponseEntity.ok(srvCl.motoDoCliente(id_cliente));
    }

    @DeleteMapping("/desativar/{id_cliente}")
    public ResponseEntity<Void> desativarCliente(@PathVariable int id_cliente) {
      Optional<Cliente> opCliente = srvCl.findById(id_cliente);
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
