package com.payment.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.demo.model.Funcionario;
import com.payment.demo.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @ResponseBody
     @GetMapping("/funcionarios")
    public List<Funcionario> listar() {
      List<Funcionario> funcionarios = funcionarioService.carregarFuncionarios();
      System.err.println(funcionarios);
      return funcionarios;
    }

    

}