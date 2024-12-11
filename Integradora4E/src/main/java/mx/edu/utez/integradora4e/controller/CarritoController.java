package mx.edu.utez.integradora4e.controller;

import mx.edu.utez.integradora4e.entity.CarritoProducto;
import mx.edu.utez.integradora4e.response.ApiResponse;
import mx.edu.utez.integradora4e.service.CarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito/agregar")
public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {this.carritoService = carritoService;}

    //PARA LISTAR CARRITOS
    @GetMapping
    public ResponseEntity<ApiResponse<List<CarritoProducto>>> listarCarritos() {
        List<CarritoProducto> carritos = carritoService.getCarritos();
        return ResponseEntity.ok(new ApiResponse<>("Se han obtenido los carritos disponibles", carritos));
    }

    //PARA AGREGAR UN CARRITO
    @PostMapping
    public ResponseEntity<ApiResponse<CarritoProducto>> agregarCarrito(@RequestBody CarritoProducto producto) {
        CarritoProducto nuevoCarrito = carritoService.addCarrito(producto);
        return ResponseEntity.ok(new ApiResponse<>("Se ha agregado un carrito exitosamente", nuevoCarrito));
    }


    //PARA BORRAR UN CARRITO
    @DeleteMapping
    public ResponseEntity<ApiResponse<CarritoProducto>> eliminarCarrito(@PathVariable Long id) {
        carritoService.borrarCarrito(id);
        return ResponseEntity.ok(new ApiResponse<>("Se ha eliminado un carrito", null));
    }




}
