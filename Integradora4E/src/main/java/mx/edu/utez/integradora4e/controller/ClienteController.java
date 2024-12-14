package mx.edu.utez.integradora4e.controller;

import mx.edu.utez.integradora4e.entity.Cliente;
import mx.edu.utez.integradora4e.response.ApiResponse;
import mx.edu.utez.integradora4e.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente/agregarCliente")
public class ClienteController  {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) { this.clienteService = clienteService; }

    @PostMapping
    public ResponseEntity<ApiResponse<Cliente>> agregarCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.guardarCliente(cliente);
        return ResponseEntity.ok(new ApiResponse<>("Cliente registrado exitosamente", nuevoCliente));
    }

}
