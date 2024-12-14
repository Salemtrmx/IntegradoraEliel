package mx.edu.utez.integradora4e.entity.dao;

import mx.edu.utez.integradora4e.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
