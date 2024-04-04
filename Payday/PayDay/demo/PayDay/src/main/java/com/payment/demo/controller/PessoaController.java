package com.payment.demo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.payment.demo.model.PessoaFisica;

@Controller
public class PessoaController {
    
    @GetMapping("/pessoas")
    public String listarPessoas(Model model) {
        // Criar instâncias de PessoaFisica
        PessoaFisica pessoa1 = new PessoaFisica(null, null, null, null, null, null, null, null, null, null, null);
        pessoa1.setNome("João Silva");
        pessoa1.setDocumento("123.456.789-00");
        pessoa1.setEndereco("Rua A, 123");
        pessoa1.setTelefone("(11) 1234-5678");
        pessoa1.setEmail("joao@example.com");
        pessoa1.setDataDeNascimento(LocalDate.of(1990, 5, 15));
        pessoa1.setSexo("M");
        pessoa1.setGrauDeInstrucao("Ensino Médio");
        pessoa1.setNomeDoPai("José Silva");
        pessoa1.setNomeDaMae("Maria Silva");
        pessoa1.setRaca("Branco");
        
        PessoaFisica pessoa2 = new PessoaFisica(null, null, null, null, null, null, null, null, null, null, null);
        pessoa2.setNome("Maria Oliveira");
        pessoa2.setDocumento("987.654.321-00");
        pessoa2.setEndereco("Av. B, 456");
        pessoa2.setTelefone("(11) 9876-5432");
        pessoa2.setEmail("maria@example.com");
        pessoa2.setDataDeNascimento(LocalDate.of(1985, 10, 20));
        pessoa2.setSexo("F");
        pessoa2.setGrauDeInstrucao("Graduado");
        pessoa2.setNomeDoPai("Carlos Oliveira");
        pessoa2.setNomeDaMae("Ana Oliveira");
        pessoa2.setRaca("PRETO");
        
        // Adicionar pessoas ao modelo
        model.addAttribute("pessoa1", pessoa1);
        model.addAttribute("pessoa2", pessoa2);
        
        // Retorna a view que irá exibir as pessoas
        return "listarPessoas";
    }
}