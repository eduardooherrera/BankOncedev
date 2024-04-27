package com.oncedev.bank.services;

import com.oncedev.bank.models.Cliente;

public interface ClienteService {

	Cliente obtenerClientes(String identificacion);
	Cliente guardarCliente(Cliente cliente);
	
}
