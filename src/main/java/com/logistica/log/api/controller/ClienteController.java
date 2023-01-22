package com.logistica.log.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.log.domain.model.Cliente;
import com.logistica.log.domain.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ClienteController {
        
        @Autowired
        private ClienteRepository clienteRepository;
        
        public ClienteController (ClienteRepository clientRepository){
            super();
            this.clienteRepository = clientRepository;
        }
	
	@GetMapping("/clientes")
	public List<Cliente> Listar() {
            return clienteRepository.findByNomeContaining("s");
	}
}
