package mx.edu.utez.integradora4e.service;


import mx.edu.utez.integradora4e.entity.CarritoProducto;
import mx.edu.utez.integradora4e.entity.Cliente;
import mx.edu.utez.integradora4e.entity.Producto;
import mx.edu.utez.integradora4e.entity.dao.ClienteRepository;
import mx.edu.utez.integradora4e.entity.dao.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupermercadoServiceImpl implements SupermercadoService {
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;

    public SupermercadoServiceImpl(ClienteRepository clienteRepository, ProductoRepository productoRepository) {
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public String procesarCompra(Long clienteId, List<CarritoProducto> productos) {
        if (productos == null || productos.isEmpty()) {
            return "El carrito está vacío, no se puede procesar la compra.";
        }
        double total = 0;
        for (CarritoProducto carritoProducto : productos) {
            Producto producto = productoRepository.findById(carritoProducto.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

            total += producto.getPrecio() * carritoProducto.getCantidad();
        }
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        return "Compra procesada exitosamente.";
    }
}