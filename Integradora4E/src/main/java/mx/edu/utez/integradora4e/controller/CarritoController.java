package mx.edu.utez.integradora4e.controller;

import mx.edu.utez.integradora4e.entity.CarritoProducto;
import mx.edu.utez.integradora4e.response.ApiResponse;
import mx.edu.utez.integradora4e.service.CarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoProductoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CarritoProducto>>> listarCarritos() {
        List<CarritoProducto> carritos = carritoService.getCarritos();
        return ResponseEntity.ok(new ApiResponse<>("Se han obtenido los carritos disponibles", carritos));
    }

    @PostMapping("/agregar")
    public CarritoProducto agregar(@RequestBody CarritoProducto carritoProducto) {
        service.addCarritoProducto(carritoProducto);
        return carritoProducto;
    }
    @GetMapping("/{clienteId}")
    public void obtenerCarrito(@PathVariable Long clienteId) {
        try {
            List<CarritoProducto> carrito = service2.obtenerCarrito(clienteId);
            return ResponseEntity.ok(carrito);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
