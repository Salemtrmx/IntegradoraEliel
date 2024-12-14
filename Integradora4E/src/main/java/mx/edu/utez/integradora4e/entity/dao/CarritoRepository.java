package mx.edu.utez.integradora4e.entity.dao;

import mx.edu.utez.integradora4e.entity.CarritoProducto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarritoRepository extends JpaRepository<CarritoProducto, Long> {
    List<CarritoProducto> findByClienteId(Long clienteId);
    Optional<CarritoProducto> findByClienteIdAndProductoId(Long clienteId, Long productoId);


}
