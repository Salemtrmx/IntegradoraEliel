package mx.edu.utez.integradora4e.service;


import mx.edu.utez.integradora4e.entity.CarritoProducto;
import mx.edu.utez.integradora4e.entity.Cliente;
import mx.edu.utez.integradora4e.entity.Producto;
import mx.edu.utez.integradora4e.entity.dao.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupermercadoServiceImpl implements SupermercadoService {
Producto p = new Producto();
    private final ClienteRepository clienteRepository;

    public SupermercadoServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public String procesarCompra(Long clienteId, List<CarritoProducto> productos) {
        if (productos == null || productos.isEmpty()) {
            return "El carrito está vacío, no se puede procesar la compra.";
        }
        double total = 0;
        for (CarritoProducto producto : productos) {
            total += p.getPrecio() * producto.getCantidad();
        }

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        return "Compra procesada exitosamente.";
    }
}