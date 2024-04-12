package com.payment.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.demo.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    
    
}
