package mx.edu.utez.integradora4e.controller;


import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Queue;

@RestController
@RequestMapping("/caja")
class CajaController {

    private final Queue<String> filaClientes = new LinkedList<>();

    // Endpoint para agregar un cliente a la fila
    @PostMapping("/agregar")
    public String agregarCliente(@RequestParam String cliente) {
        filaClientes.add(cliente);
        return "Cliente agregado: " + cliente;
    }

    // Endpoint para mostrar los clientes en la fila
    @GetMapping("/fila")
    public Queue<String> obtenerFila() {
        return filaClientes;
    }
    }