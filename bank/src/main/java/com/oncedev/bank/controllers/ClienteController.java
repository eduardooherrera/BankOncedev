package com.oncedev.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.oncedev.bank.models.Cliente;
import com.oncedev.bank.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(path = "/{identificacion}")
	public ResponseEntity<?> obtener(@PathVariable(value = "identificacion") String identificacion) {
		
		Cliente cliente = clienteService.obtenerClientes(identificacion);
		if(cliente == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra cliente");
		
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
				
	}
	
	@PostMapping
	public Cliente guardar(@RequestBody @Validated Cliente cliente) {
		return clienteService.guardarCliente(cliente);
	}
}
