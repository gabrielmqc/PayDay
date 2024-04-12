package com.payment.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.demo.model.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Long> {
    
}
