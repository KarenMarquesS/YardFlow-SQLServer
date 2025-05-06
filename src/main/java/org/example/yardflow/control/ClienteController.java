package org.example.yardflow.control;

public class ClienteController {
}

//!!! ANTES DE QUALQUER COISA, REVER TUDO COM ATENÇÃO!!!

//@RestController
//@RequestMapping("/clientes")
//public class ClienteController {
//
//    @Autowired
//    private ClienteCachingService clienteService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ClienteDTO> buscarCliente(@PathVariable int id) {
//        return ResponseEntity.ok(clienteService.buscarCliente(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ClienteDTO> atualizarCliente(@RequestBody ClienteDTO clienteDTO) {
//        return ResponseEntity.ok(clienteService.atualizarCliente(clienteDTO));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable int id) {
//        clienteService.deletarCliente(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<ClienteDTO>> listarPaginado(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size
//    ) {
//        Pageable pageable = PageRequest.of(page, size);
//        return ResponseEntity.ok(clienteService.listarClientesPaginado(pageable));
//    }
//
//    @GetMapping("/{id}/motos")
//    public ResponseEntity<List<Moto>> listarMotosDoCliente(@PathVariable int id) {
//        return ResponseEntity.ok(clienteService.getMotosPorCliente(id));
//    }
//}
