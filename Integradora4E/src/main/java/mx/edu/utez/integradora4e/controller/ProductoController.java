package mx.edu.utez.integradora4e.controller;

import mx.edu.utez.integradora4e.entity.Producto;
import mx.edu.utez.integradora4e.response.ApiResponse;
import mx.edu.utez.integradora4e.service.ProductoService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto/agregarProducto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {this.productoService = productoService;}

    @GetMapping
    public ResponseEntity<ApiResponse<List<Producto>>> listarProductos() {
        List<Producto> productos = productoService.listarProducto();
        return ResponseEntity.ok(new ApiResponse<>("Se ha obtenido el listado de los productos", productos));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Producto>> guardarProducto(@RequestBody Producto producto) {
        Producto agregarProducto = productoService.guardarProducto(producto);
        return ResponseEntity.ok(new ApiResponse<>("Se ha agregado el producto", agregarProducto));
    }
}
