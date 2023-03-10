package com.logistica.log.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.log.domain.model.Cliente;
import com.logistica.log.domain.repository.ClienteRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
        
    @Autowired
    private ClienteRepository clienteRepository;
        
    public ClienteController (ClienteRepository clientRepository){
        super();
        this.clienteRepository = clientRepository;
    }
	
	@GetMapping
	public List<Cliente> Listar() {
            return clienteRepository.findByNomeContaining("a");
	}

    @GetMapping("/{clienteId}")
    public ResponseEntity <Cliente> buscar(@PathVariable Long clienteId) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId,
    @Valid @RequestBody Cliente cliente){
                if(!clienteRepository.existsById(clienteId)){
                    return ResponseEntity.notFound().build();
                }

                cliente.setId(clienteId);
                cliente = clienteRepository.save(cliente);

                return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId){
        if(!clienteRepository.existsById(clienteId)){
        return ResponseEntity.notFound().build();
    }
    clienteRepository.deleteById(clienteId);

    return ResponseEntity.noContent().build();
    }
}
