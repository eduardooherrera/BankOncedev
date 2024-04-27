package com.oncedev.bank.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.oncedev.bank.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
