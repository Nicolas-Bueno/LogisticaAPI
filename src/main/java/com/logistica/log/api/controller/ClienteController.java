package com.logistica.log.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.log.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> Listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("João");
		cliente1.setTelefone("99988-1125");
		cliente1.setEmail("joaodascouve@gmail.com");

		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Maria");
		cliente2.setTelefone("8985-3025");
		cliente2.setEmail("mariasilva@gmail.com");
		return Arrays.asList(cliente1,cliente2);
	}
}
