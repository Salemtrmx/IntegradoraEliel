package mx.edu.utez.integradora4e.entity.dao;

import mx.edu.utez.integradora4e.entity.CarritoProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<CarritoProducto, Integer> {
    static void deleteById(Long id) {
    }
}
