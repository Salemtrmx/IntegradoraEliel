package mx.edu.utez.integradora4e.entity.dao;

import mx.edu.utez.integradora4e.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
