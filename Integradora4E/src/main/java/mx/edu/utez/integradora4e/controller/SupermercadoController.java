package mx.edu.utez.integradora4e.controller;

import mx.edu.utez.integradora4e.controller.CajaController;
import mx.edu.utez.integradora4e.entity.CarritoProducto;
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
public class SupermercadoController {

    @Autowired
    private CarritoService carritoService;

    @Autowired
    private CajaController cajaController;

    @PostMapping("/comprar/{clienteId}")
    public ResponseEntity<String> procesarCompra(@PathVariable Long clienteId) {
        try {
            List<CarritoProducto> productosCarrito = carritoService.obtenerCarritoPorCliente(clienteId);

            if (productosCarrito.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El carrito está vacío.");
            }

            double totalPagar = 0.0;
            List<String> detalles = new ArrayList<>();
            detalles.add("Detalle de compra:");

            for (CarritoProducto item : productosCarrito) {
                double subtotal = item.getCantidad() * item.getProducto().getPrecio();
                totalPagar += subtotal;
                detalles.add(String.format("- %s (Cantidad: %d, Precio: %.2f) -> Subtotal: %.2f",
                        item.getProducto().getNombre(),
                        item.getCantidad(),
                        item.getProducto().getPrecio(),
                        subtotal));
            }

            detalles.add(String.format("Total a pagar: %.2f", totalPagar));

            carritoService.limpiarCarrito(clienteId);

            cajaController.atenderCliente();

            String mensajeCompra = String.join("\n", detalles);

            return ResponseEntity.ok(mensajeCompra);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la compra.");
        }
    }

}

