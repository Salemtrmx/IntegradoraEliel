package mx.edu.utez.integradora4e.controller;


import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Queue;


@RestController
@RequestMapping("/caja")
class CajaController {

    private final Queue<String> filaClientes = new LinkedList<>();

    @PostMapping("/agregar")
    public String agregarCliente(@RequestParam String cliente) {
        filaClientes.add(cliente);
        return "Cliente agregado: " + cliente;
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

