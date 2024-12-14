package mx.edu.utez.integradora4e.controller;


import mx.edu.utez.integradora4e.entity.Cliente;
import mx.edu.utez.integradora4e.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/supermercado")
public class SuperMercadoController {

    @Autowired
    private CarritoService carritoService;

    private List<Cliente> filaDeClientes = new ArrayList<>();

    // Método para agregar clientes a la fila
    @PostMapping("/agregarCliente/{clienteId}")
    public ResponseEntity<String> agregarCliente(@PathVariable Long clienteId) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteId);
        filaDeClientes.add(cliente); // Añadimos el cliente a la fila
        return ResponseEntity.ok("Cliente agregado a la fila.");
    }

    // Método para ver la fila de clientes
    @GetMapping("/ver-fila")
    public List<Cliente> verFila() {
        return filaDeClientes;
    }

    // Método para atender un cliente de la fila (primer cliente)
    @GetMapping("/atender-cliente")
    public ResponseEntity<String> atenderCliente() {
        if (filaDeClientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay clientes en la fila.");
        }
        Cliente clienteAtendido = filaDeClientes.remove(0); // Remover el primer cliente de la fila
        return ResponseEntity.ok("Cliente atendido: " + clienteAtendido.getId());
    }


}
