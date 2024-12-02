package mx.edu.utez.integradora4e.service;

import mx.edu.utez.integradora4e.entity.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> listarProducto();
    Producto guardarProducto(Producto producto);
}
