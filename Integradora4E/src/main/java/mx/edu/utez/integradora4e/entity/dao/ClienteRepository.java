package mx.edu.utez.integradora4e.entity.dao;

import mx.edu.utez.integradora4e.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findById(Long id);
}
