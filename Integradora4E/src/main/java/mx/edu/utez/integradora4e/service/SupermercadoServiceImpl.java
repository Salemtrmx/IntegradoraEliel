package mx.edu.utez.integradora4e.service;


import mx.edu.utez.integradora4e.entity.CarritoProducto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupermercadoServiceImpl implements SupermercadoService {

    @Override
    public String procesarCompra(Long clienteId, List<CarritoProducto> productos) {
        return "compra realizada con exito";
    }
}