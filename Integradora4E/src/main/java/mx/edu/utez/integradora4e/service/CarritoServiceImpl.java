package mx.edu.utez.integradora4e.service;

import mx.edu.utez.integradora4e.entity.CarritoProducto;
import mx.edu.utez.integradora4e.entity.dao.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CarritoServiceImpl implements  CarritoService{

    @Autowired
    CarritoRepository dao;

    @Override
    @org.springframework.transaction.annotation.Transactional
    public CarritoProducto addCarritoProducto(CarritoProducto carritoProducto) {
        dao.save(carritoProducto);
        return carritoProducto;
    }

    @Override
    @Transactional
    public CarritoProducto eliminarCarritoProducto(Long clienteId, Long productoId) {
        Optional<CarritoProducto> carritoProducto = dao.findByClienteIdAndProductoId(clienteId, productoId);
        if (carritoProducto.isPresent()) {
            dao.deleteById(carritoProducto.get().getId());
            return carritoProducto.get();
        }
        return null;
    }

    @Override
    public List<CarritoProducto> obtenerCarritoPorCliente(Long clienteId) {
        return dao.findByClienteId(clienteId);
    }

    @Override
    public void limpiarCarrito(Long clienteId) {
        List<CarritoProducto> productosCarrito = dao.findByClienteId(clienteId);
        productosCarrito.forEach(producto -> dao.deleteById(producto.getId()));
    }

}
