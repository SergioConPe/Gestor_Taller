package com.taller.gestion.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.gestion.Model.Cliente;
import com.taller.gestion.Repository.*;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
//Guardar un nuevo cliente
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
//Lista de clientes
	public List<Cliente> findAllClientes(){
		return clienteRepository.findAll();
	}
//Buscar un cliente por su ID
	public Cliente findById(Long id) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		return optionalCliente.orElse(null);//Devuelve cliente si lo encuentra
	}
	// Actualizar un cliente
    public Cliente updateCliente(Long id, Cliente clienteActualizado) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setTelefono(clienteActualizado.getTelefono());
            return clienteRepository.save(cliente);//Guarda cliente actualizado
        }
        return null;
    }
//Eliminar cliente por su id
    public void deleteById(Long id) {
    	clienteRepository.deleteById(id);
    	System.out.println("SE HA ELIMINADO AL CLIENTE DEL SISTEMA" + id);
    }
}
