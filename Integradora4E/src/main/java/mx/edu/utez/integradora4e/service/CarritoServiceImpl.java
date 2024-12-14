package mx.edu.utez.integradora4e.service;

import mx.edu.utez.integradora4e.entity.CarritoProducto;
import mx.edu.utez.integradora4e.entity.dao.CarritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoServiceImpl implements  CarritoService{
    private final CarritoRepository carritoRepository;
    private final Map<Long, Stack<CarritoProducto>> historialEliminados = new Has

    private final CarritoRepository carritoRepository;
    public CarritoServiceImpl(CarritoRepository carritoRepository) {this.carritoRepository = carritoRepository;}

    @Override
    public List<CarritoProducto> getCarritos() {
        return carritoRepository.findAll();
    }

    @Override
    public CarritoProducto addCarrito(CarritoProducto carrito) {
        return carritoRepository.save(carrito);
    }
}
