package mx.edu.utez.integradora4e.controller;

import mx.edu.utez.integradora4e.entity.CarritoProducto;
import mx.edu.utez.integradora4e.response.ApiResponse;
import mx.edu.utez.integradora4e.service.CarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {this.carritoService = carritoService;}

    @GetMapping("/listar")
    public ResponseEntity<ApiResponse<List<CarritoProducto>>> listarCarritos() {
        List<CarritoProducto> carritos = carritoService.getCarritos();
        return ResponseEntity.ok(new ApiResponse<>("Se han obtenido los carritos disponibles", carritos));
    }

    @PostMapping("/agregar")
    public ResponseEntity<ApiResponse<CarritoProducto>> agregarCarrito(@RequestBody CarritoProducto producto) {
        CarritoProducto nuevoCarrito = carritoService.addCarrito(producto);
        return ResponseEntity.ok(new ApiResponse<>("Se ha agregado un carrito exitosamente", nuevoCarrito));
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<ApiResponse<CarritoProducto>> obtenerCarritoById(@PathVariable Integer id) {
        CarritoProducto buscarCarritoById = carritoService.buscarCarritoPorId(id);
        return ResponseEntity.ok(new ApiResponse<>("Se obtuvo el carrito del usuario", buscarCarritoById));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<ApiResponse<CarritoProducto>> borrarCarrito(@PathVariable Long id) {
        carritoService.borrarCarrito(id);
        return  ResponseEntity.ok(new ApiResponse<>("Carrito Eliminado", null));
    }
}
