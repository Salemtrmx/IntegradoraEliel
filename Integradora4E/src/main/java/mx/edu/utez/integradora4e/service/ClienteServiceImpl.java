package mx.edu.utez.integradora4e.service;

import mx.edu.utez.integradora4e.entity.Cliente;
import mx.edu.utez.integradora4e.entity.dao.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) { this.clienteRepository = clienteRepository; }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
    return clienteRepository.save(cliente);
    }


}
