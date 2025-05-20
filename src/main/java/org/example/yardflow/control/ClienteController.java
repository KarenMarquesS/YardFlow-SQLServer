package org.example.yardflow.control;

import jakarta.validation.Valid;
import org.example.yardflow.dto.ClienteDTO;
import org.example.yardflow.model.Cliente;
import org.example.yardflow.model.Moto;
import org.example.yardflow.service.ClienteCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

      @Autowired
    private ClienteCachingService srvCl;

    @PostMapping("/inserir")
    public ResponseEntity<ClienteDTO> inserirCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO salvo =
                srvCl.inserirCliente(clienteDTO);
                srvCl.limparCachingCliente();
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/buscar/{id_cliente}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable int id_cliente) {
        Optional<Cliente> cliente = srvCl.findById(id_cliente);
        return cliente.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar/{id_cliente}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable("id_cliente") int id_cliente, @RequestBody @Valid ClienteDTO dto) {
        if (dto.getId_cliente() != id_cliente) throw new IllegalArgumentException(">> Divergência de ID <<");

        ClienteDTO atualizado = srvCl.atualizarCliente(dto);
        return ResponseEntity.ok(atualizado);

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
      boolean desativado = srvCl.desativarCliente(id_cliente);
      return desativado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
