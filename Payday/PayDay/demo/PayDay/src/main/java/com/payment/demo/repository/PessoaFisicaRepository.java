package com.payment.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.demo.model.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    
}
