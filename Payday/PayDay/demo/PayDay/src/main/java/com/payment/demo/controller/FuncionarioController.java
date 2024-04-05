package com.payment.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.demo.model.Funcionario;
import com.payment.demo.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    private Funcionario funcionario;
    
    @GetMapping
    public FuncionarioService exibirFuncionario(){
        return funcionarioService;
    }
    @PostMapping
    public void adicionarEvento(@RequestBody FuncionarioService funcionarioService, Funcionario funcionario) {
        funcionarioService.executarEvento(funcionario.getTipoEvento());
    }

    
}