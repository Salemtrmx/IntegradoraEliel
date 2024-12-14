package mx.edu.utez.integradora4e.service;

import mx.edu.utez.integradora4e.entity.CarritoProducto;

import java.util.List;

public interface CarritoService {
    public CarritoProducto addCarritoProducto(CarritoProducto carritoProducto);
    public CarritoProducto eliminarCarritoProducto(Long clienteId, Long productoId);
    public List<CarritoProducto> obtenerCarritoPorCliente(Long clienteId);
    public void limpiarCarrito(Long clienteId);
}
