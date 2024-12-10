package mx.edu.utez.integradora4e.service;

import mx.edu.utez.integradora4e.entity.CarritoProducto;

import java.util.List;

public interface CarritoService {
    List<CarritoProducto> getCarritos();
    CarritoProducto addCarrito(CarritoProducto carrito);
    void borrarCarrito(Long id);


}