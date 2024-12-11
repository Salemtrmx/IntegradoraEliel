package mx.edu.utez.integradora4e.controller;


import mx.edu.utez.integradora4e.entity.Cliente;
import mx.edu.utez.integradora4e.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Queue;


@RestController
@RequestMapping("/caja")
class CajaController {

    private final Queue<String> filaClientes = new LinkedList<>();
    private final ClienteService clienteService;

    public CajaController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/agregar")
    public String agregarCliente(@RequestParam Long clienteId) {
        Cliente cliente = clienteService.obtenerClientePorId(clienteId);
        if (cliente == null) {
            return "Cliente no encontrado con ID: " + clienteId;
        }
        filaClientes.add(cliente.getNombre());
        return "Cliente agregado a la fila: " + cliente.getNombre();
    }

    @GetMapping("/atender")
    public String atenderCliente() {
        if (filaClientes.isEmpty()) {
            return "No hay clientes en la fila.";
        }
        String clienteAtendido = filaClientes.poll();
        return "Cliente atendido: " + clienteAtendido;
    }

    @GetMapping("/obtenerFila")
    public Queue<String> obtenerFila() {
        return filaClientes;
    }
}
