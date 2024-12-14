package mx.edu.utez.integradora4e.controller;
import mx.edu.utez.integradora4e.entity.CarritoProducto;
import mx.edu.utez.integradora4e.service.SupermercadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supermercado")
public class SuperMercadoController {
    private final SupermercadoService supermercadoService;

    public SuperMercadoController(SupermercadoService supermercadoService) {
        this.supermercadoService = supermercadoService;
    }

    @PostMapping("/comprar/{clienteId}")
    public ResponseEntity<String> procesarCompra(@PathVariable Long clienteId, @RequestBody List<CarritoProducto> productos) {
        String respuesta = supermercadoService.procesarCompra(clienteId, productos);
        return ResponseEntity.ok(respuesta);
    }
}