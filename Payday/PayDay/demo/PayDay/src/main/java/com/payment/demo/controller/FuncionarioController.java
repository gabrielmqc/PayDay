package com.payment.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

  @GetMapping("/{documento}")
  public ResponseEntity<Funcionario> buscarPorDocumento(@PathVariable String documento) {

    Funcionario funcionario = funcionarioService.buscarPorDocumento(documento);

    return ResponseEntity.ok(funcionario);

  }

  @PutMapping("/{documento}")
  public ResponseEntity<Funcionario> atualizar(@PathVariable String documento,
      @RequestBody Funcionario func) {

    Funcionario atualizado = funcionarioService.atualizar(func);
    System.out.println("Funcionário atualizado: " + atualizado);
    return ResponseEntity.ok(atualizado);

  }

  @PutMapping("/funcionarios/{documento}")
  public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable String documento,
      @RequestBody Funcionario funcionario) {

    Funcionario f = funcionarioService.atualizarEventos(documento, funcionario.getEventos());

    funcionarioService.calcularSalarioLiquido(f);

    return ResponseEntity.ok(f);
  }

}