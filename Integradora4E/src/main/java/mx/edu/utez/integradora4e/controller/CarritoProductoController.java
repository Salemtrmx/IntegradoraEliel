package mx.edu.utez.integradora4e.controller;

import mx.edu.utez.integradora4e.Utils.CustomStack;
import mx.edu.utez.integradora4e.entity.CarritoProducto;
import mx.edu.utez.integradora4e.response.ApiResponse;
import mx.edu.utez.integradora4e.service.CarritoService;
import mx.edu.utez.integradora4e.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carrito")
public class CarritoProductoController {

    @Autowired
    private  CarritoService service;

    @Autowired
    private ClienteService service2;

    private final Map<Long, CustomStack<CarritoProducto>> historialEliminados= new HashMap<>();


    @PostMapping("/agregar")
    public CarritoProducto agregar(@RequestBody CarritoProducto carritoProducto) {
        service.addCarritoProducto(carritoProducto);
        return carritoProducto;
    }
    @GetMapping("/{clienteId}")
    public ResponseEntity<?> obtenerCarrito(@PathVariable Long clienteId) {
        try {
            List<CarritoProducto> carrito = service2.obtenerCarrito(clienteId);
            return ResponseEntity.ok(carrito);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PostMapping("/eliminar/{clienteId}/{productoId}")
    public ResponseEntity<String> eliminar(@PathVariable Long clienteId, @PathVariable Long productoId) {
        if (clienteId == null || productoId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("IDs de cliente y producto son obligatorios.");
        }

        CarritoProducto productoEliminado = service.eliminarCarritoProducto(clienteId, productoId);
        if (productoEliminado != null) {
            historialEliminados
                    .computeIfAbsent(clienteId, k -> new CustomStack<>(100))
                    .push(productoEliminado);
            return ResponseEntity.ok("Producto eliminado del carrito.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo eliminar el producto.");
    }

    @PostMapping("/deshacer/{clienteId}")
    public ResponseEntity<String> deshacerEliminacion(@PathVariable Long clienteId) {
        CustomStack<CarritoProducto> historial = historialEliminados.get(clienteId);
        if (historial != null && !historial.isEmpty()) {
            CarritoProducto productoRestaurado = historial.pop();

            // Crear una nueva instancia de la entidad para evitar problemas con Hibernate
            CarritoProducto nuevoProducto = new CarritoProducto();
            nuevoProducto.setCantidad(productoRestaurado.getCantidad());
            nuevoProducto.setCliente(productoRestaurado.getCliente());
            nuevoProducto.setProducto(productoRestaurado.getProducto());

            // Guardar EL CARRITO QUE SE DESHIZO
            service.addCarritoProducto(nuevoProducto);
            return ResponseEntity.ok("Producto restaurado al carrito.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay eliminaciones para deshacer.");
    }

}
