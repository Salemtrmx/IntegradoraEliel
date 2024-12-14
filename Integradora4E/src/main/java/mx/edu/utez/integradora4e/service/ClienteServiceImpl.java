package mx.edu.utez.integradora4e.service;

import mx.edu.utez.integradora4e.entity.CarritoProducto;
import mx.edu.utez.integradora4e.entity.Cliente;
import mx.edu.utez.integradora4e.entity.dao.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) { this.clienteRepository = clienteRepository; }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
    return clienteRepository.save(cliente);
    }

@Override
public Cliente obtenerClientePorId(Long id) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        return clienteOpt.orElse(null);
    }

    @Override
    public List<CarritoProducto> obtenerCarrito(Long id){
        Cliente cliente=clienteRepository.findById(id).orElseThrow(()->new RuntimeException("No hay cliente con ese Id"));
        return cliente.getCarrito();
    }


}
