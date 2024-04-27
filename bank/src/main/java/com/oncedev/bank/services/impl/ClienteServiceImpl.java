package com.oncedev.bank.services.impl;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oncedev.bank.models.Cliente;
import com.oncedev.bank.repositories.ClienteRepository;
import com.oncedev.bank.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository clienteRepository; 
	
	
	@Override
	public Cliente guardarCliente(Cliente cliente) {
		
	    return clienteRepository.save(cliente);

	}

	@Override
	public Cliente obtenerClientes(String identificacion) {
		Cliente cliente = clienteRepository.findById(identificacion).orElse(null);
		if(cliente != null)
		{
			String encriptado = encriptar(cliente.getIdentificacion());			
			cliente.setIdentificacion(encriptado);
		}
		return cliente;
	}
	
    public String encriptar(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = md.digest(texto.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

	
}
