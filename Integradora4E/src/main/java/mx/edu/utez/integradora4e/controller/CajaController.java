package mx.edu.utez.integradora4e.controller;


import mx.edu.utez.integradora4e.entity.Cliente;
import mx.edu.utez.integradora4e.response.ApiResponse;
import mx.edu.utez.integradora4e.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Queue;


@RestController
@RequestMapping("/caja")
public class CajaController {

    private final Queue<String> filaClientes = new LinkedList<>();
    private final ClienteService clienteService;

    public CajaController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/agregar")
    public String agregarCliente(@RequestParam Long clienteId) {
        try {
            Cliente cliente = clienteService.obtenerClientePorId(clienteId);
            if (cliente == null) {
                return "Cliente no encontrado con ID: " + clienteId;
            }
            filaClientes.add(cliente.getNombre());
            return "Cliente agregado a la fila: " + cliente.getNombre();
        } catch (Exception e) {
            e.printStackTrace();
            return "Ocurrió un error al agregar el cliente a la fila: " + e.getMessage();
        }
    }
    @GetMapping("/atender")
    public ResponseEntity<ApiResponse<String>> atenderCliente() {
        try {
            if (filaClientes.isEmpty()) {
                return ResponseEntity.ok(new ApiResponse<>("No hay clientes en la fila.", null));
            }
            String clienteAtendido = filaClientes.poll();
            return ResponseEntity.ok(new ApiResponse<>("Cliente atendido: " + clienteAtendido, clienteAtendido));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ApiResponse<>("Error al atender al cliente: " + e.getMessage(), null));
        }
    }
    @GetMapping("/obtenerFila")
    public Queue<String> obtenerFila() {
        return filaClientes;
    }
}
