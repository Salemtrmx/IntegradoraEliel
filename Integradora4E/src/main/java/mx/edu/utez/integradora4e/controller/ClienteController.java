package mx.edu.utez.integradora4e.controller;

import mx.edu.utez.integradora4e.entity.Cliente;
import mx.edu.utez.integradora4e.response.ApiResponse;
import mx.edu.utez.integradora4e.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController  {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) { this.clienteService = clienteService; }

    @GetMapping("/listar")
    public ResponseEntity<ApiResponse<List<Cliente>>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(new ApiResponse<>("Se ha obtenido el listado de clientes", clientes));
    }

    @PostMapping("/agregar")
    public ResponseEntity<ApiResponse<Cliente>> agregarCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.guardarCliente(cliente);
        return ResponseEntity.ok(new ApiResponse<>("Cliente registrado exitosamente", nuevoCliente));
    }

}
