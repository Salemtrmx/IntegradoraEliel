package mx.edu.utez.integradora4e.service;

import mx.edu.utez.integradora4e.entity.Producto;
import mx.edu.utez.integradora4e.entity.dao.ClienteRepository;
import mx.edu.utez.integradora4e.entity.dao.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ClienteRepository clienteRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository, ClienteRepository clienteRepository) {this.productoRepository = productoRepository;
        this.clienteRepository = clienteRepository;
    }


    @Override
    public List<Producto> listarProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }
}
