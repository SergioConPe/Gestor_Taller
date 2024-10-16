package com.taller.gestion.Controller;

import com.taller.gestion.Model.Cliente;
import com.taller.gestion.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.saveCliente(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    // Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.findAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateClienteController(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {
        Cliente cliente = clienteService.updateCliente(id, clienteActualizado);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
