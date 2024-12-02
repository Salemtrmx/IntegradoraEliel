package mx.edu.utez.integradora4e.service;

import mx.edu.utez.integradora4e.entity.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> listarClientes();
    Cliente guardarCliente(Cliente cliente);
}
