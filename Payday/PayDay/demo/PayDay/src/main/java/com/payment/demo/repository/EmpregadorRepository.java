package com.payment.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.demo.model.Empregador;

public interface EmpregadorRepository extends JpaRepository<Empregador, Long> {
    
}
