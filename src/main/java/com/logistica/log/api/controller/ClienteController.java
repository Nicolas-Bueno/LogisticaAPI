package com.logistica.log.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.log.domain.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
public class ClienteController {

	@PersistenceContext
	private EntityManager maneger;
	
	@GetMapping("/clientes")
	public List<Cliente> Listar() {
		
		return maneger.createQuery("from Cliente", Cliente.class).getResultList();
	}
}
