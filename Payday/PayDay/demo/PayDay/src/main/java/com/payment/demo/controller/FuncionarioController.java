package com.payment.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.demo.model.Dependente;
import com.payment.demo.model.Eventos;
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

    @GetMapping("/{cpf}")
    public Funcionario buscarPorCPF(@PathVariable String cpf) {
        Optional<Funcionario> optionalFuncionario = funcionarioService.buscarPorCPF(cpf);
        return optionalFuncionario.orElse(null); // Retorna o funcionário se encontrado, caso contrário, retorna null
    }

    @PostMapping("/{cpf}/eventos")
    public ResponseEntity<String> inserirEventos(@PathVariable String cpf, @RequestBody Eventos eventos) {
        Funcionario funcionario = funcionarioService.buscarPorCPF(cpf);
        if (funcionario != null) {
            funcionarioService.processarEventos(funcionario, eventos);
            return ResponseEntity.ok("Eventos inseridos com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
        }
    }


}