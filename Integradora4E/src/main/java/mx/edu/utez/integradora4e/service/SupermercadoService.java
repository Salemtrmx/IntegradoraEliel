package mx.edu.utez.integradora4e.service;

import mx.edu.utez.integradora4e.entity.CarritoProducto;

import java.util.List;

public interface SupermercadoService {
    String procesarCompra(Long clienteId, List<CarritoProducto> productos);
}